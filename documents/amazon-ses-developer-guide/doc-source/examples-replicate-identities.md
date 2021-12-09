# Replicating email identities across AWS Regions<a name="examples-replicate-identities"></a>

If you want to use the same identity to send email in more than one AWS Region, you have to verify that identity in each Region\. The Python script in this example simplifies the process of verifying an identity in a new Region if you've already verified it in a different Region\.

You can use this script to replicate either email address or domain identities\. If you use this script to replicate an email address, you have to click the verification link in the email that Amazon SES sends to that address\. You can only use this script to replicate a domain identity if the DNS settings for that domain are managed by Route 53\.

**Note**  
Your sandbox and account quota settings are unique to each AWS Region\. In other words, if your account has been removed from the Amazon SES sandbox in one Region, you still have to have it removed in each other Region\. For more information about having your account removed from the Amazon SES sandbox, see [Moving out of the Amazon SES sandbox](request-production-access.md)\. For more information about increasing your Amazon SES service quotas, see [Increasing your Amazon SES sending quotas](manage-sending-quotas-request-increase.md)\.

```
import json
import sys
import boto3
from boto3 import Session
from botocore.exceptions import ClientError


# Calls SES API to trigger a verification email.
def email_verify(email_list, client):
    for email in email_list:
        response = client.\
                   verify_email_identity(EmailAddress=email)


# Calls SES API to generate a verification token for the domain being verified.
def domain_verify(domain_list, client):
    token_list = []
    for domain in domain_list:
        response = client.verify_domain_identity(Domain=domain)
        token_list.append(response['VerificationToken'])
    verification_table = dict(zip(domain_list, token_list))
    # print(verificationTable)
    return verification_table


# Calls Route53 API to add a TXT record with the verification token for all
# domains in the verification table.
def add_route_53_record(table='', rec_type='', dkim_dom='', dkim_tok='', r53=''):
    ses_prefix = "_amazonses."
    zone_list = []
    # Added pagination for listing hosted zones
    paginator_hz = r53.get_paginator('list_hosted_zones')
    response_iterator_hz = paginator_hz.\
                           paginate(
                                    PaginationConfig={
                                                      'MaxItems': 20,
                                                      'PageSize': 20
                                                      }
                                    )
    for item in response_iterator_hz:
        for z in item['HostedZones']:
            zone_list.append(z)
    if rec_type == 'domainVerify':
        for domain in table:
            print(domain)
            for zone in zone_list:
                compare = '.'.join(domain.split('.')[-2:])
                if compare == zone['Name'][:-1]:
                    zone_id = zone['Id'].strip('/hostedzone/')
                    record_list = []
                    paginator_rr = r53.\
                                  get_paginator('list_resource_record_sets')
                    resp_iterator_rr =\
                                      paginator_rr.\
                                      paginate(
                                               HostedZoneId=zone_id,
                                               PaginationConfig={
                                                                 'MaxItems': 20,
                                                                 'PageSize': 20
                                                                 }
                                                )
                    for item in resp_iterator_rr:
                        for i in item['ResourceRecordSets']:
                            record_list.append(i)
                    is_txt_present = False
                    for r_set in record_list:
                        if (r_set['Name'][:-1] ==
                                                 ses_prefix+domain and
                                                 r_set['Type'] == 'TXT'):
                            is_txt_present = True
                            txt_vals = r_set['ResourceRecords']
                            token = json.dumps(table[domain])
                            txt_vals.append({'Value': token})
                            batch = {
                                     "Changes": [
                                                 {"Action": "UPSERT",
                                                  "ResourceRecordSet":
                                                  {
                                                   "Name": ses_prefix+domain,
                                                   "Type": "TXT",
                                                   "TTL": 1800,
                                                   "ResourceRecords": txt_vals
                                                  }
                                                  }
                                                 ]
                                    }
                            try:
                                add_txt = r53.change_resource_record_sets(
                                          HostedZoneId=zone_id,
                                          ChangeBatch=batch
                                          )
                                # print(add_txt)
                            except ClientError as err:
                                print(err)
                                if (err.response['Error']['Code'] ==
                                     'InvalidChangeBatch'):
                                    print("Check if TXT record",
                                           "for the domain already exists.\n")
                        else:
                            pass

                    if is_txt_present is False:
                        token = json.dumps(table[domain])
                        batch = {
                                 "Changes": [
                                             {"Action": "UPSERT",
                                             "ResourceRecordSet":
                                              {"Name": ses_prefix+domain,
                                              "Type": "TXT", "TTL": 1800,
                                              "ResourceRecords":
                                              [{"Value": token}]}
                                              }
                                             ]
                                  }
                        add_txt = r53.change_resource_record_sets(
                                  HostedZoneId=zone_id,
                                  ChangeBatch=batch
                                  )
                else:
                    pass
    elif rec_type == 'dkimVerify':
        for zone in zone_list:
            compare = '.'.join(dkim_dom.split('.')[-2:])
            print(compare)
            if compare == zone['Name'][:-1]:
                zone_id = zone['Id'].strip('/hostedzone/')
                batch = {
                        "Changes": [
                                    {"Action": "UPSERT",
                                     "ResourceRecordSet":
                                     {"Name": dkim_tok+"._domainkey."+dkim_dom,
                                      "Type": "CNAME", "TTL": 1800,
                                      "ResourceRecords":
                                      [{"Value": dkim_tok+".dkim.amazonses.com"}
                                       ]
                                      }
                                     }
                                    ]
                         }
                add_txt = r53.change_resource_record_sets(
                                                          HostedZoneId=zone_id,
                                                          ChangeBatch=batch
                                                         )
                # print(add_txt)
            else:
                pass


# Enable DKIM and add CNAME records for verification.
def generate_dkim(identity, client, dom_check, dns_client):
    ask = input("Do you want to configure DKIM for "+identity+"? (yes/no)")
    if ask == 'yes':
        if '@' in identity:
            dkim_tokens = client.verify_domain_dkim(Domain=identity.\
                                                    split('@')[1])['DkimTokens']
            if dom_check == 'no':
                print("Add the following DKIM tokens as \
                      CNAME records through your DNS provider:")
                print(dkim_tokens)
            elif dom_check == 'yes':
                for token in dkim_tokens:
                    # Then add CNAME records
                    add_route_53_record(rec_type='dkimVerify',
                                        dkim_dom=identity.split('@')[1],
                                        dkim_tok=token,
                                        r53=dns_client
                                        )
        else:
            dkim_tokens = client.verify_domain_dkim(Domain=identity)['DkimTokens']
            if dom_check == 'no':
                print("Add the following DKIM tokens as \
                      CNAME records through your DNS provider:")
                print(dkim_tokens)
            elif dom_check == 'yes':
                for token in dkim_tokens:
                    # Then add CNAME records
                    add_route_53_record(rec_type='dkimVerify',
                                        dkim_dom=identity,
                                        dkim_tok=token,
                                        r53=dns_client
                                        )
    elif ask == 'no':
        return


# Add SNS topic for bounces, deliveries, and complaints for a single identity.
def sns_topics(identity, client):
    ask = input("Do you want to configure an SNS topic for "+identity+"? (yes/no)")
    if ask == 'yes':
        bounce_topic = input("Enter ARN of bounce topic: ")
        if bounce_topic == '':
            pass
        else:
            try:
                client.ses_identity_notif_topic(Identity=identity,
                                                NotifType='Bounce',
                                                SnsTopic=bounce_topic
                                                )
            except ClientError:
                print("Invalid ARN")

        delivery_topic = input("Enter ARN of delivery topic: ")
        if delivery_topic == '':
            pass
        else:
            try:
                client.ses_identity_notif_topic(Identity=identity,
                                                NotifType='Delivery',
                                                SnsTopic=delivery_topic
                                                )
            except ClientError:
                print("Invalid ARN")

        complaint_topic = input("Enter ARN of complaint topic: ")
        if complaint_topic == '':
            pass
        else:
            try:
                client.ses_identity_notif_topic(Identity=identity,
                                                NotifType='Complaint',
                                                SnsTopic=complaint_topic
                                                )
            except ClientError:
                print("Invalid ARN")
    elif ask == 'no':
        return


def main():
    s = Session()
    # Returns list of regions where SES is available.
    regions = s.get_available_regions('ses')
    print("This is the list of available regions:")
    print(regions)

    # Source region.
    while True:
        src_region = input("Which region do you want to replicate from? ")
        if src_region in regions:
            # Create SES client for source region.
            ses_source_client = s.client('ses', region_name=src_region)
            region_email_identities = []
            region_dom_identities = []
            # Added pagination for listing SES identities.
            paginator = ses_source_client.get_paginator('list_identities')
            response_iterator = paginator.paginate(PaginationConfig={
                                                                     'MaxItems': 20,
                                                                     'PageSize': 20
                                                                    }
                                                   )
            for entry in response_iterator:
                for element in entry['Identities']:
                    if '@' in element:
                        region_email_identities.append(element)
                    else:
                        region_dom_identities.append(element)
            print("Email addresses in source region:")
            print(region_email_identities)
            print("Domains in source region:")
            print(region_dom_identities)
            break

        else:
            print("Region entered invalid. ",
                  "Please enter a region where SES is available.")

    # Destination region.
    while True:
        dst_region = input("Which region do you want to replicate to? ")
        if dst_region in regions:
            # Create SES client for destination region.
            ses_dest_client = s.client('ses', region_name=dst_region)
            email_call = email_verify(region_email_identities, ses_dest_client)
            verification_table = domain_verify(region_dom_identities, ses_dest_client)

            # Route53 subroutine. Based on user-input, used if
            # domains being verified are in Route53.
            r53dom = input("Are your domains hosted in Route53?(yes/no) ")
            if r53dom == 'yes':
                # Prints domain names and their verification tokens.
                print(verification_table)
                print("")
                r53_client = s.client('route53')
                add_route_53_record(table=verification_table,
                                    rec_type='domainVerify',
                                    r53=r53_client
                                    )
            elif r53dom == 'no':
                print("Use the verification tokens returned to ",
                      "create TXT records through your DNS provider.")
                # Prints domain names and their verification tokens.
                print(verification_table)
                print("")

            # SNS topic addition
            sns = input("Do you want to add SNS notifications for the identities? (yes/no) ")
            if sns == 'yes':
                for addr in region_email_identities:
                    sns_topics(addr, ses_dest_client)
                for dom in region_dom_identities:
                    sns_topics(dom, ses_dest_client)
            elif sns == 'no':
                pass

            # DKIM verification
            dkim = input("Do you want to configure DKIM for the identities? (yes/no) ")
            if dkim == 'yes':
                for addr in region_email_identities:
                    generate_dkim(addr, ses_dest_client, r53dom, r53_client)
                for dom in region_dom_identities:
                    generate_dkim(dom, ses_dest_client, r53dom, r53_client)
            break


        else:
            print("Region entered invalid. ",
                  "Please enter a region where SES is available.")


if __name__ == '__main__':
    main()
```
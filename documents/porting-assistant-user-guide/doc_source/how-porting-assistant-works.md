# How Porting Assistant for \.NET works<a name="how-porting-assistant-works"></a>

Porting Assistant for \.NET analyzes source code for supported APIs and packages \(Microsoft Core APIs and packages, and public and private NuGet packages\)\. It identifies incompatible API calls made from each package and checks whether a package is compatible with \.NET Core\. Porting Assistant parses package reference files for each project in the \.NET Framework solution, and iterates through each referenced public and private NuGet package, as well as each Microsoft Core API and package, to check whether the latest version of the package that is compatible with \.NET Core is available\. To speed up the process, Porting Assistant includes a precompiled database of all public NuGet packages and Microsoft Core APIs and packages and their compatibility status\. For private packages, Porting Assistant uses dotnet tools to determine the compatibility of a package\. After compatibility for all packages is determined, you can view the package status at both the project and solution level, as a graph that shows package dependencies\. 

Porting Assistant uses the compatibility information of the NuGet packages and Microsoft Core packages and APIs to assign a compatibility score, which is an estimation of the effort required by the application to port the application to \.NET Core\. You can use the compatibility score to identify and prioritize applications for your porting project\.

When you select an application for porting, Porting Assistant can speed up the process by setting up the project file with updated NuGet/Microsoft packages and formatted package references in a format that is compatible with \.NET Core\. You can use the updated project file to improve your application porting time\. When you select an application for porting, Porting Assistant copies the \.NET Framework source code and the associated project files to a \.NET Core compatible format\. If there are any known replacements, Porting Assistant applies them\. When a project is ported, it might not be entirely \.NET Core compatible because there may be other APIs, packages, and code blocks that must be substituted and refactored for compatibility\.

## Information collected<a name="porting-assistant-information-collected"></a>

When you scan your source code, Porting Assistant collects the compatibility information on the public NuGet packages and the APIs within the packages that are in use by your application\. Porting Assistant doesn’t collect source code or information about your private NuGet packages\. In the case of failure, the tool might collect stack traces to improve product experience\. You have the option to disable telemetry gathering from within the tool at any time in the **Settings** menu of the Porting Assistant tool\. 

If you accept the data collection option in the **Settings** menu of the Porting Assistant tool, the following application data is collected:

1. Application errors generated when running assessments, porting, or when performing other functions provided by the Porting Assistant tool\.

1. Names and versions of public NuGet packages assessed by the Porting Assistant tool\.

1. Metrics for assessments run by the Porting Assistant tool on public NuGet packages, such as the number of packages and solutions, and the amount of time taken to create a solution\.

Porting Assistant leverages the information on the public NuGet packages and APIs to continuously improve its API replacement suggestions\. Porting Assistant periodically analyzes the collected information and updates its replacement engine so that the experience continuously improves\.
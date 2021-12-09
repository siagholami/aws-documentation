# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
This script contains tests that verify the checkin_tests script works as expected.
"""
import pytest

import checkin_tests


@pytest.mark.parametrize("file_contents,expected_error_count", [
    ("Test file contents.\n" \
     "This URL is not allowed: http://alpha-docs-aws" + ".amazon.com/test\n" \
     "And neither is this one:\n" \
     "https://integ-docs-aws" + ".amazon.com/something-else\n" \
     "But that's it for denied words.", 2),
    ("This string has no denied words.\n"
     "And neither does this one.", 0)
])
def test_verify_no_deny_list_words(file_contents, expected_error_count):
    """Test that file contents that contain disallowed words are counted as errors."""
    error_count = checkin_tests.verify_no_deny_list_words(file_contents, "location")
    assert error_count == expected_error_count


@pytest.mark.parametrize("file_contents,expected_error_count", [
    ("This sentence has a hidAKAAIOS" + "FODNN7EXAMPLEden secret key.", 1),
    ("This sentence has a hidAKIAIOSFO" + "DNN7EXAMPLEden example key.", 0),
    ("This sentence has nothing interesting about it at all.", 0),
    ("This could be a secret key, I guess: aws/monitoring/mo"
     "del/DeleteAlarmsRequbbb\n"
     "And so could this: TargetTrackingScalingP" + "olicy1234567891234\n"
     "Not this: wJalrXUtnFEMI/K7MDENG/bPxR" + "fiCYEXAMPLEKEY is allowed!", 2),
    ("Normal_file_name.py", 0),
    ("Something AppStreamUsageReportsCFNGl" + "ueAthenaAccess.cs", 0),
    ("Something AppStreamUsageReportsCFNGlue" + "AtNotAllowed.py", 1),
])
def test_verify_no_secret_keys(file_contents, expected_error_count):
    """Test that file contents that contain 20- or 40-character strings and are
    not in the allowed list are counted as errors."""
    error_count = checkin_tests.verify_no_secret_keys(file_contents, "location")
    assert error_count == expected_error_count


@pytest.mark.parametrize("file_contents,expected_error_count", [
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "This is not code.\n"
     "snippet" + "-end:[this.is.a.snippet.tag]", 0),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "This is not code.\n"
     "snippet" + "-end:[this.is.a.different.snippet.tag]", 2),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "This is not code.", 1),
    ("This is not code.\n"
     "snippet" + "-end:[this.is.a.snippet.tag]", 1),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "snippet" + "-start:[this.is.a.different.snippet.tag]\n"
     "This is not code.\n"
     "snippet" + "-end:[this.is.a.snippet.tag]\n"
     "snippet" + "-end:[this.is.a.different.snippet.tag]\n", 0),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "snippet" + "-start:[this.is.a.different.snippet.tag]\n"
     "This is not code.\n"
     "snippet" + "-end:[this.is.a.different.snippet.tag]\n"
     "snippet" + "-end:[this.is.a.snippet.tag]\n", 0),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "This is not code.\n"
     "snippet" + "-end:[this.is.a.snippet.tag.with.extra.stuff]\n", 2),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
     "snippet" + "-start:[this.is.a.snippet.tag]\n"
     "This is not code.\n"
     "snippet" + "-end:[this.is.a.snippet.tag]\n", 1),
    ("snippet" + "-start:[this.is.a.snippet.tag]\n"
      "This is not code.\n"
      "snippet" + "-end:[this.is.a.snippet.tag]\n"
      "snippet" + "-end:[this.is.a.snippet.tag]\n", 1),
])
def test_verify_snippet_start_end(file_contents, expected_error_count):
    """Test that various kinds of mismatched snippet-start and -end tags are
    counted correctly as errors."""
    error_count = checkin_tests.verify_snippet_start_end(file_contents, "location")
    assert error_count == expected_error_count

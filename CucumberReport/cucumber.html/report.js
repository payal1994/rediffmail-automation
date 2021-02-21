$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Compose.feature");
formatter.feature({
  "line": 1,
  "name": "Compose a mail",
  "description": "",
  "id": "compose-a-mail",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4794371600,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "User login to the application with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "ComposeMailStepDefinition.user_login_to_the_application_with_valid_credentials()"
});
formatter.result({
  "duration": 4401009200,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Verify user is able to Compose mail and send mail without subject",
  "description": "",
  "id": "compose-a-mail;verify-user-is-able-to-compose-mail-and-send-mail-without-subject",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "User navigate to \"Write mail\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Verify New Mail tab is open",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Verify all links and icon on that tab",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User composes the mail \"without subject\" and \"valid\" recipient",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "click on \"Send\" button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User verify \"No Subject\" pop up message",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User verify \"mail has been sent\" message",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Write mail",
      "offset": 18
    }
  ],
  "location": "ComposeMailStepDefinition.user_navigate_to_diffirent_tab(String)"
});
formatter.result({
  "duration": 165333600,
  "status": "passed"
});
formatter.match({
  "location": "ComposeMailStepDefinition.verify_New_Mail_tab_is_open()"
});
formatter.result({
  "duration": 271877300,
  "status": "passed"
});
formatter.match({
  "location": "ComposeMailStepDefinition.verify_all_links_and_icon_on_that_tab()"
});
formatter.result({
  "duration": 1885829400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "without subject",
      "offset": 24
    },
    {
      "val": "valid",
      "offset": 46
    }
  ],
  "location": "ComposeMailStepDefinition.user_composes_the_mail_and_send_it(String,String)"
});
formatter.result({
  "duration": 130858600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Send",
      "offset": 10
    }
  ],
  "location": "ComposeMailStepDefinition.click_on_button(String)"
});
formatter.result({
  "duration": 91402500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No Subject",
      "offset": 13
    }
  ],
  "location": "ComposeMailStepDefinition.verify_popUp_messages(String)"
});
formatter.result({
  "duration": 382147100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mail has been sent",
      "offset": 13
    }
  ],
  "location": "ComposeMailStepDefinition.user_verify_the_sent_mail_message(String)"
});
formatter.result({
  "duration": 22152836000,
  "error_message": "junit.framework.AssertionFailedError\r\n\tat junit.framework.Assert.fail(Assert.java:55)\r\n\tat junit.framework.Assert.fail(Assert.java:64)\r\n\tat com.rediffmail.utilities.CommonLibreary.getEleText(CommonLibreary.java:67)\r\n\tat com.rediffmail.utilities.CommonLibreary.verifyContainsText(CommonLibreary.java:126)\r\n\tat com.rediffmail.pages.ComposePage.verifySuccessMsg(ComposePage.java:156)\r\n\tat com.rediffmail.stepdefinitions.ComposeMailStepDefinition.user_verify_the_sent_mail_message(ComposeMailStepDefinition.java:86)\r\n\tat ✽.And User verify \"mail has been sent\" message(Compose.feature:13)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1085907000,
  "status": "passed"
});
});
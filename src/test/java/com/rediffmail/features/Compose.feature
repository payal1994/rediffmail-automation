Feature: Compose a mail

Background:
Given User login to the application with valid credentials

Scenario: Verify user is able to Compose mail and send mail without subject
When User navigate to "Write mail"
Then Verify New Mail tab is open
And  Verify all links and icon on that tab
When User composes the mail "without subject" and "valid" recipient
And click on "Send" button
Then User verify "No Subject" pop up message
And User verify "mail has been sent" message

Scenario: Verify user is able to Compose mail with subject
When User navigate to "Write mail"
Then Verify New Mail tab is open
When User composes the mail "with subject" and "valid" recipient
And click on "Send" button
And User verify "mail has been sent" message

Scenario: Verify user gets warning pop up for cancelling mail and  when trying to send mail with empty or invalid recipient id 
When User navigate to "Write mail"
Then Verify New Mail tab is open
When click on "Send" button
Then User verify "Empty Recipient" pop up message
When User composes the mail "with subject" and "invalid" recipient
And click on "Send" button
Then User verify "Invalid Recipient" pop up message
When click on "Cancel" button
Then User verify "Discard Mail" pop up message


Scenario: Verify user is able to Compose mail and save it
When User navigate to "Write mail"
Then Verify New Mail tab is open
When User composes the mail "with subject" and "valid" recipient
And click on "Save" button
And User verify "Saving mail." message






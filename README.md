This is a very simple program to send an email in java. 
This program has a logic to restrict email id to specific domain for example: "@aol.com". any other domain will be ignored.

1. Download the project or clone it to local workspace
2. Open project in eclipse
3. Edit the TLSEmail file
	- update fromEmail to your test gmail account
	- update password of your gmail account
	- update toEmail, ccEmail, bccEmail to known email ids for test
	- update EmailUtil.sendEmail() with the right domain you want to restrict to.
4. You may want to modify the code to support SSL, email with attachments etc..

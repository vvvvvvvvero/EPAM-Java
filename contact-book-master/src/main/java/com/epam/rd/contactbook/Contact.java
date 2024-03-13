package com.epam.rd.contactbook;

import java.util.Arrays;

public class Contact {

    private String contactName;
    private ContactInfo phoneNumber;
    private ContactInfo[] emails;
    private Social[] socials;
    private int emailsAdded = 0;
    private int socialsAdded = 0;


    public Contact(String contactName) {
        this.contactName = contactName;
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        public String localPart;
        public String domain;

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        public Email() {}

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

    public static class Social implements ContactInfo {
        public String tittle;
        public String value;

        public Social(String tittle, String value) {
            this.tittle = tittle;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return tittle;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public void rename(String newName) {
        if (newName != null && !newName.equals(""))
        {
            contactName = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (emailsAdded == 3) {
            return null;
        }

        if (emails == null) {
            emails = new Email[1];
        } else {
            emails = Arrays.copyOf(emails, emailsAdded + 1);
        }
        Email email = new Email(localPart, domain);
        emails[emailsAdded++] = email;
        return email;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if (emailsAdded == 3) {
            return null;
        }

        if (emails == null) {
            emails = new Email[1];
        } else {
            emails = Arrays.copyOf(emails, emailsAdded + 1);
        }

        Email email = new Email(){
            @Override
            public String getTitle() {
                return "Epam Email";
            }

            @Override
            public String getValue() {
                return firstname + "_" + lastname + "@epam.com";
            }
        };
        emails[emailsAdded++] = email;
        return email;

    }


    public ContactInfo addPhoneNumber(int code, String number) {
        if (phoneNumber != null) {
            return null;
        }

        ContactInfo phone = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };
        phoneNumber = phone;
        return phone;

    }

    public Social addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public Social addSocialMedia(String title, String id) {
        if (socialsAdded == 5) {
            return null;
        }
        if (socials == null) {
            socials = new Social[1];
        } else {
            socials = Arrays.copyOf(socials, socialsAdded + 1);
        }
        Social social = new Social(title, id);
        socials[socialsAdded++] = social;
        return social;
    }

    public ContactInfo[] getInfo() {
        int curr = 1;
        int contactInfoSize = 1;
        if(phoneNumber != null) {
            contactInfoSize++;
            curr++;
        }
        ContactInfo[] contactInfos = new ContactInfo[contactInfoSize + emailsAdded + socialsAdded];
        contactInfos[0] = new NameContactInfo();
        if(phoneNumber != null){
            contactInfos[1] = phoneNumber;
        }

        for (int i =0;i < emailsAdded;i++){
            contactInfos[curr++] = emails[i];
        }

        for (int i =0;i < socialsAdded;i++){
            contactInfos[curr++] = socials[i];
        }
        return contactInfos;

    }

}

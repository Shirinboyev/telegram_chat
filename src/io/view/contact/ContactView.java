package io.view.contact;

import io.FrontEnd;
import io.utils.Utils;

public class ContactView {
    public static void addContact() {
        Integer number = Utils.enterInt("Enter number : ");

        if (number.equals(FrontEnd.currentUser.getPhoneNumber())) {
            System.out.println("It is your number idiot! ");
            return;
        }
    }
}

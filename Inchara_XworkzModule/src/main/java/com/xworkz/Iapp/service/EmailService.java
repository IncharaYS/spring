package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;

public interface EmailService {

    IssueCode sendOtpMail(String toEmail);

}

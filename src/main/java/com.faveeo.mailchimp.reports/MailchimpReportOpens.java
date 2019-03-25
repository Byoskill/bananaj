/*
 * FAVEEO SA
 * __________________
 *
 *  [2016] - [2019] Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Faveeo SA and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Faveeo SA
 * and its suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Faveeo SA.
 */
package com.faveeo.mailchimp.reports;

import org.joda.time.DateTime;

public class MailchimpReportOpens {
    public int opens_total;
    public int unique_opens;
    public double open_rate;
    public DateTime last_open;
}

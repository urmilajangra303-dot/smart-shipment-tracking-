package com.shipment.smartshipment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



import javax.management.Notification;
import java.util.List;

@FeignClient(name = "SMART-NOTIFICATION")
public class NotificationClient {

}

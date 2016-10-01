package org.gday.appb;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;

@Service
public class ApplicationService {

 private final ResourceIdResolver resourceIdResolver;

 @Autowired
 public ApplicationService(ResourceIdResolver resourceIdResolver) {
 	this.resourceIdResolver = resourceIdResolver;
 }

 public String getPhysicalName(String logicalName) {
 	String physicalName = this.resourceIdResolver.resolveToPhysicalResourceId(logicalName);
	return physicalName;
 }
}

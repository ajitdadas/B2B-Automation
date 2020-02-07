package com.cisco.b2b.util;

import java.util.ArrayList;
import java.util.List;

import com.cisco.b2b.model.Address;
import com.cisco.b2b.model.B2BResponse;
import com.cisco.b2b.model.ConfigResponse;
import com.cisco.b2b.model.ConfigurationLine;
import com.cisco.b2b.model.InstallSiteLocation;
import com.cisco.b2b.model.MajorLine;
import com.cisco.b2b.model.MinorLine;
import com.cisco.b2b.model.ServiceLine;
import com.cisco.b2b.model.XaasMinorLine;

public class CiscoOneResponseComparator {

	public static List<CompareResult> compareResponse(ConfigResponse configResponse, B2BResponse b2bResponse) throws NoSuchFieldException, SecurityException{
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		List<MajorLine> majorLines = configResponse.getMajorLine() != null && !configResponse.getMajorLine().isEmpty() ? configResponse.getMajorLine()  : new ArrayList<MajorLine>();
		List<ConfigurationLine> parentLines = new ArrayList<>(); 
		List<ConfigurationLine> serviceLinesB2B = new ArrayList<>();
		List<ConfigurationLine> minorLines = new ArrayList<>();
		List<ConfigurationLine> xaasMinorLines = new ArrayList<>();
		for(ConfigurationLine configurationLine :  b2bResponse.getConfigurationLine()) {
			if(configurationLine.getParentID().equals("0")) {
				parentLines.add(configurationLine);
			}
			else if(configurationLine.getParentID().equals("1") && configurationLine.getItemType().equals("SERVICE")) {
				serviceLinesB2B.add(configurationLine);
			}
			else if(!configurationLine.getParentID().equals("0") && (configurationLine.getItemType().equals("CONFIGURABLE") || configurationLine.getItemType().equals("NONCONFIGURABLE")) && (configurationLine.getXaasAttributes()==null)) {
				minorLines.add(configurationLine);
			}
			else if(!configurationLine.getParentID().equals("0") &&  ((configurationLine.getXaasAttributes()!=null))) {
				xaasMinorLines.add(configurationLine);
			}
		}
	
		for(MajorLine majorLine : majorLines) {
			ConfigurationLine configurationLine = null;
			for(ConfigurationLine cLine : parentLines) {
				if(majorLine.getItemName().equals(cLine.getItemName())) {
					configurationLine = cLine;	
					break;
				}
			}
			compareResults.addAll(compareConfigMajorLineResponse(majorLine, configurationLine));

			List<ServiceLine> serviceLineConfig = majorLine.getServiceLine();
			for(ServiceLine serLineConfigIterator : serviceLineConfig) {
				for(ConfigurationLine serLine : serviceLinesB2B) {
                 if(serLineConfigIterator.getItemName().equals(serLine.getItemName())) {
						System.out.println(serLineConfigIterator.getItemName());
						configurationLine = serLine;
						break;
					}
				}
				compareResults.addAll(compareServiceLine(serLineConfigIterator, configurationLine));	
			}	

			List<MinorLine> minorLineConfig = majorLine.getMinorLine();
			for(MinorLine minorLineIterator : minorLineConfig ) {
				for(ConfigurationLine minLine : minorLines) {
					if(minorLineIterator.getItemName().equals(minLine.getItemName())) {
						configurationLine = minLine;
						break;
					}
				}
				compareResults.addAll(compareMinorLine(minorLineIterator, configurationLine));
			}
			
		   List<XaasMinorLine> xaasMinorLine = majorLine.getXaasMinorLine();
		   for(XaasMinorLine xaasMinorLineIterator : xaasMinorLine) {
			   for(ConfigurationLine xaasLine : xaasMinorLines) {
				   if(xaasMinorLineIterator.getItemName().equals(xaasLine.getItemName())) {
					   configurationLine = xaasLine;
					   break;
				   }
			   }
			   compareResults.addAll(compareXaasMinorLine(xaasMinorLineIterator, configurationLine));
		   }

		}


		return compareResults;
	}

	public static List<CompareResult> compareConfigMajorLineResponse(MajorLine majorLine,
			ConfigurationLine configurationLine) {
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		
		
		if(majorLine.getBundleFlag() != null && configurationLine.getProductAttributes().getBundleFlag() !=null) 
		{
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		if(majorLine.getBundleFlag() != null && configurationLine.getProductAttributes().getBundleFlag() == null)
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		
		if(majorLine.getBundleFlag() == null && configurationLine.getProductAttributes().getBundleFlag() != null)
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		
	
	   	if(majorLine.getConfigPath() != null && configurationLine.getConfigPath()!=null)
	   	{
			if(!majorLine.getConfigPath().equals(configurationLine.getConfigPath()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "Config Path", majorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		if(majorLine.getConfigPath() != null && configurationLine.getConfigPath() == null)
		
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Config Path", majorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		
		if(majorLine.getConfigPath() == null && configurationLine.getConfigPath() != null)
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Config Path", majorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		
		
	    if(majorLine.getSelectionFlag() != null && configurationLine.getSelectionCode()!=null) 
	    {
			if(!majorLine.getSelectionFlag().equals(configurationLine.getSelectionCode()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "SelectionCode", majorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		}
		if(majorLine.getSelectionFlag() != null && configurationLine.getSelectionCode() == null)
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "SelectionCode", majorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}	
		if(majorLine.getSelectionFlag() == null && configurationLine.getSelectionCode() != null) 
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "SelectionCode", majorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
	
	    if(majorLine.getStatus() != null && configurationLine.getStatus()!=null)
	    {
			if(!majorLine.getStatus().equals(configurationLine.getStatus()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "Status", majorLine.getStatus(), configurationLine.getStatus(), false));
			}
	   	}
		if(majorLine.getStatus() != null && configurationLine.getStatus() == null) 
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Status", majorLine.getStatus(), configurationLine.getStatus(), false));
			}
		if(majorLine.getStatus() == null && configurationLine.getStatus() != null) 
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Status", majorLine.getStatus(), configurationLine.getStatus(), false));
			}
		
		 InstallSiteLocation installSiteLocation = configurationLine.getInstallSiteLocation();
		Address address = installSiteLocation.getAddress();
		if (address != null) {
			if (address.getCountryCode() != null) {
				if (!installSiteLocation.getAddress().getCountryCode().equals(majorLine.getInstallSiteLocation().getCountry())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "InstallSite|Country",
						majorLine.getInstallSiteLocation().getCountry(), installSiteLocation.getAddress().getCountryCode(),
						false));
			}
		}
		}
	    
	     
			if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
	    	{
	    		if(majorLine.getProductAttributes().gettAAFlag() != null && configurationLine.getProductAttributes().gettAAIndicator()!=null) 
	    		{
	    			if(!majorLine.getProductAttributes().gettAAFlag().equals(configurationLine.getProductAttributes().gettAAIndicator()))
	    			{
	    				compareResults.add(createCompareResult(majorLine.getItemName(), "TAAIndicator", majorLine.getProductAttributes().gettAAFlag(), configurationLine.getProductAttributes().gettAAIndicator(), false));
	    			}
	    		}
	    	}
	    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()==null) 
	    	{
				compareResults.add(createCompareResult(majorLine.getItemName(), "TAAIndicator", majorLine.getProductAttributes().gettAAFlag(), configurationLine.getProductAttributes().gettAAIndicator(), false));
			}
	    	if(majorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null) 
	    	{
				compareResults.add(createCompareResult(majorLine.getItemName(), "TAAIndicator", majorLine.getProductAttributes().gettAAFlag(), configurationLine.getProductAttributes().gettAAIndicator(), false));
			}
	    		
	    	
		    if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
		    	{
		    		if(majorLine.getProductAttributes().gettEPFlag()!= null && configurationLine.getProductAttributes().gettEPIndicator()!=null)
		    		{
		    			if(!majorLine.getProductAttributes().gettEPFlag().equals(configurationLine.getProductAttributes().gettEPIndicator()))
		    			{
		    				compareResults.add(createCompareResult(majorLine.getItemName(), "TEPIndicator", majorLine.getProductAttributes().gettEPFlag(), configurationLine.getProductAttributes().gettEPIndicator(), false));
		    			}
		    		}
		    	}
		    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()==null) 
		    	{
					compareResults.add(createCompareResult(majorLine.getItemName(), "TEPIndicator", majorLine.getProductAttributes().gettEPFlag(), configurationLine.getProductAttributes().gettEPIndicator(), false));
				}
		    	if(majorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null) 
		    	{
		    		compareResults.add(createCompareResult(majorLine.getItemName(), "TEPIndicator", majorLine.getProductAttributes().gettEPFlag(), configurationLine.getProductAttributes().gettEPIndicator(), false));
				}
		    		
		    	
		   
		
	     
	     
		    if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
		    	{
		    		if(majorLine.getProductAttributes().getSmartAccountRequiredconfig()!= null && configurationLine.getProductAttributes().getSmartAccountRequired()!=null)
		    		{
		    			if(!majorLine.getProductAttributes().getSmartAccountRequiredconfig().equals(configurationLine.getProductAttributes().getSmartAccountRequired()))
		    			{
		    				compareResults.add(createCompareResult(majorLine.getItemName(), "SmartAccountRequired", majorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
		    			}
		    		}
		    	}
		    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()==null) 
		    	{
		    		compareResults.add(createCompareResult(majorLine.getItemName(), "SmartAccountRequired", majorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
				}
		    	if(majorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null) 
		    	{
		    		compareResults.add(createCompareResult(majorLine.getItemName(), "SmartAccountRequired", majorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
				}
		    		
		    	
		    	if(majorLine.getItemType() != null && configurationLine.getItemType()!=null)
		    	{
		    		if (!majorLine.getItemType().equals(configurationLine.getItemType())) 
		    		{
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),configurationLine.getItemType(), false));
		    		}
		    	}
			if(majorLine.getItemType() != null && configurationLine.getItemType() == null) 
				{
					compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),configurationLine.getItemType(), false));
				}
			if(majorLine.getItemType() == null && configurationLine.getItemType() != null)
				{
					compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),configurationLine.getItemType(), false));
				}
			
		
	     if(majorLine.getQuantity() != null && configurationLine.getQuantity()!=null) 
	     	{
	    	 	if (!majorLine.getQuantity().equals(configurationLine.getQuantity()))
	    	 		{
	    	 			compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),configurationLine.getQuantity(), false));
		    		}
			}
			if(majorLine.getQuantity() != null && configurationLine.getQuantity() == null)
				{
					compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),configurationLine.getQuantity(), false));
				}
			if(majorLine.getQuantity() == null && configurationLine.getQuantity() != null)
				{
					compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),configurationLine.getQuantity(), false));
				}
			
		
			if(majorLine.getUnitListPrice()!= null && configurationLine.getPricingInformation()!=null)
		    	{
		    		if(majorLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice()!=null)
		    		{
				if(!majorLine.getUnitListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getUnitListPrice().stripTrailingZeros()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice", majorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
				}
		    		}
		    	}
		    	if(majorLine.getUnitListPrice() != null && configurationLine.getPricingInformation()==null) 
		    		{
							compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice", majorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
		    		}
				    		
		    	if(majorLine.getUnitListPrice() == null && configurationLine.getPricingInformation()!=null) 
		    		{
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice", majorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
		    		}
			    		
		    	
		  
	     
	     
	     
	     
		    	if(majorLine.getExtendedListPrice()!= null && configurationLine.getPricingInformation()!=null)
		    	{
		    		if(majorLine.getExtendedListPrice() != null && configurationLine.getPricingInformation().getExtendedListPrice()!=null) {
				if(!majorLine.getExtendedListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getExtendedListPrice().stripTrailingZeros()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "ExtendedListPrice", majorLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
				}
		    		}
		    	}
		    	if(majorLine.getExtendedListPrice() != null && configurationLine.getPricingInformation()==null) 
		    	{
		    		if(majorLine.getExtendedListPrice() != null && configurationLine.getPricingInformation().getExtendedListPrice()!=null) {
						if(!majorLine.getExtendedListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getExtendedListPrice().stripTrailingZeros()))
					    {
							compareResults.add(createCompareResult(majorLine.getItemName(), "ExtendedListPrice", majorLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
						}
				    		}
		    	}
		    	if(majorLine.getExtendedListPrice() == null && configurationLine.getPricingInformation()!=null) 
		    	{if(majorLine.getExtendedListPrice() != null && configurationLine.getPricingInformation().getExtendedListPrice()!=null) {
					if(!majorLine.getExtendedListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getExtendedListPrice().stripTrailingZeros()))
				    {
						compareResults.add(createCompareResult(majorLine.getItemName(), "ExtendedListPrice", majorLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
					}
			    		}
		    	}
		  
	     
	     
	     
	     
		    	if(majorLine.getDescription() != null && configurationLine.getDescription()!=null) {
		    		if (!majorLine.getDescription().equals(configurationLine.getDescription())) {
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "Description", majorLine.getDescription(),
		    					configurationLine.getDescription(), false));

		    		}
			}
			if(majorLine.getDescription() != null && configurationLine.getDescription() == null) {
				if (!majorLine.getDescription().equals(configurationLine.getDescription())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "Description", majorLine.getDescription(),
							configurationLine.getDescription(), false));

				}
			}
			if(majorLine.getDescription() == null && configurationLine.getDescription() != null) {
				if (!majorLine.getDescription().equals(configurationLine.getDescription())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "Description", majorLine.getDescription(),
							configurationLine.getDescription(), false));

				}
			}
		
	     
	     
	     
	    
		    	if(majorLine.getLeadTime() != null && configurationLine.getLeadTime()!=null) 
		    	{
		    		if (!majorLine.getLeadTime().equals(configurationLine.getLeadTime().getDuration()))
		    		{
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "LeadTime",majorLine.getLeadTime(),
		    					configurationLine.getLeadTime().getDuration(), false));
		    		}
			  }
		    
		    	if(majorLine.getLeadTime() != null && configurationLine.getLeadTime()==null) 
		    	{
		    		if (!majorLine.getLeadTime().equals(configurationLine.getLeadTime().getDuration()))
		    		{
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "LeadTime",majorLine.getLeadTime(),
		    					configurationLine.getLeadTime().getDuration(), false));
		    		}
			  }
		    	if(majorLine.getLeadTime() == null && configurationLine.getLeadTime()!=null) 
		    	{
		    		if (!majorLine.getLeadTime().equals(configurationLine.getLeadTime().getDuration()))
		    		{
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "LeadTime",majorLine.getLeadTime(),
		    					configurationLine.getLeadTime().getDuration(), false));
		    		}
			  }
	     
		    	
	     
		    	if(majorLine.getServiceable() != null && configurationLine.getProductAttributes().getServiceable() !=null) {
					if(!majorLine.getServiceable().equals(configurationLine.getProductAttributes().getServiceable())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "serviceable", majorLine.getServiceable(), configurationLine.getProductAttributes().getServiceable(), false));
					}
				}
		    	if(majorLine.getServiceable() != null && configurationLine.getProductAttributes().getServiceable() ==null) {
					if(!majorLine.getServiceable().equals(configurationLine.getProductAttributes().getServiceable())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "serviceable", majorLine.getServiceable(), configurationLine.getProductAttributes().getServiceable(), false));
					}
				}
		    	if(majorLine.getServiceable() == null && configurationLine.getProductAttributes().getServiceable() !=null) {
					if(!majorLine.getServiceable().equals(configurationLine.getProductAttributes().getServiceable())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "serviceable", majorLine.getServiceable(), configurationLine.getProductAttributes().getServiceable(), false));
					}
				}
	     
		    	
		    	
		    	
		    	
	     
		    	if(majorLine.getAllowedDifferentialDuration() != null && configurationLine.getProductAttributes().getAllowedDifferentialDuration() !=null) {
					if(!majorLine.getAllowedDifferentialDuration().equals(configurationLine.getProductAttributes().getAllowedDifferentialDuration())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "allowedDifferentialDuration", majorLine.getAllowedDifferentialDuration(), configurationLine.getProductAttributes().getAllowedDifferentialDuration(), false));
					}
				}
		    	if(majorLine.getAllowedDifferentialDuration() != null && configurationLine.getProductAttributes().getAllowedDifferentialDuration() ==null) {
					if(!majorLine.getAllowedDifferentialDuration().equals(configurationLine.getProductAttributes().getAllowedDifferentialDuration())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "allowedDifferentialDuration", majorLine.getAllowedDifferentialDuration(), configurationLine.getProductAttributes().getAllowedDifferentialDuration(), false));
					}
				}
		    	if(majorLine.getAllowedDifferentialDuration() == null && configurationLine.getProductAttributes().getAllowedDifferentialDuration() !=null) {
					if(!majorLine.getAllowedDifferentialDuration().equals(configurationLine.getProductAttributes().getAllowedDifferentialDuration())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "allowedDifferentialDuration", majorLine.getAllowedDifferentialDuration(), configurationLine.getProductAttributes().getAllowedDifferentialDuration(), false));
					}
				}
	     
	         
		    	
		    	if(majorLine.getSourceLineId() != null && configurationLine.getSourceLineID() !=null) {
					if(!majorLine.getSourceLineId().get(0).equals(configurationLine.getSourceLineID())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "sourceLineId",majorLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
					}
				}
		    	if(majorLine.getSourceLineId() != null && configurationLine.getSourceLineID() ==null) {
					//if(!majorLine.getSourceLineId().get(0).equals(configurationLine.getSourceLineID())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "sourceLineId",majorLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
					}
		    	if(majorLine.getSourceLineId() == null && configurationLine.getSourceLineID() !=null) {
					//if(!majorLine.getSourceLineId().get(0).equals(configurationLine.getSourceLineID())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "sourceLineId",majorLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
		    	}
		
		return compareResults;
	}
	
	
	public static List<CompareResult> compareServiceLine(ServiceLine serviceLine,
			ConfigurationLine configurationLine) {
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		//serviceLine = majorLine.getServiceLine() ;
		
		if(serviceLine.getServiceLevelName() != null && configurationLine.getServiceAttributes().getServiceLevelName() !=null) {
			if(!serviceLine.getServiceLevelName().equals(configurationLine.getServiceAttributes().getServiceLevelName())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "ServiceLevelName", serviceLine.getServiceLevelName(), configurationLine.getServiceAttributes().getServiceLevelName(), false));
			}
		}
		if(serviceLine.getServiceLevelName() != null && configurationLine.getServiceAttributes().getServiceLevelName() ==null) {
				compareResults.add(createCompareResult(serviceLine.getItemName(), "ServiceLevelName", serviceLine.getServiceLevelName(), configurationLine.getItemName(), false));
			
		}
		if(serviceLine.getServiceLevelName() == null && configurationLine.getServiceAttributes().getServiceLevelName() !=null) {
				compareResults.add(createCompareResult(serviceLine.getItemName(), "ServiceLevelName", serviceLine.getItemName(), configurationLine.getServiceAttributes().getServiceLevelName(), false));
			
		}
		
		if(serviceLine.getDurationListPrice() != null && configurationLine.getPricingInformation().getDurationListPrice() !=null) {
			if(!serviceLine.getDurationListPrice().equals(configurationLine.getPricingInformation().getDurationListPrice())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "Duration List Price", serviceLine.getDurationListPrice(), configurationLine.getPricingInformation().getDurationListPrice(), false));
			}
		}
		if(serviceLine.getDurationListPrice() != null && configurationLine.getPricingInformation().getDurationListPrice() ==null) {
				compareResults.add(createCompareResult(serviceLine.getItemName(), "Duration List Price", serviceLine.getDurationListPrice(), configurationLine.getPricingInformation().getDurationListPrice(), false));
			
		}
		if(serviceLine.getDurationListPrice() == null && configurationLine.getPricingInformation().getDurationListPrice() !=null) {
				compareResults.add(createCompareResult(serviceLine.getItemName(), "Duration List Price", serviceLine.getDurationListPrice(), configurationLine.getPricingInformation().getDurationListPrice(), false));
			
		}
		
	
		
	/*	if(serviceLine.getSourceLineId() != null && configurationLine.getSourceLineID() !=null) {
			if(!serviceLine.getSourceLineId().get(0).equals(configurationLine.getSourceLineID())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "sourceLineId", serviceLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
			}
		}
		
		if(serviceLine.getSourceLineId() != null && configurationLine.getSourceLineID() ==null) {
				compareResults.add(createCompareResult(serviceLine.getItemName(), "sourceLineId", serviceLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
		}
		
		if(serviceLine.getSourceLineId() == null && configurationLine.getSourceLineID() !=null) {
				compareResults.add(createCompareResult(serviceLine.getItemName(), "sourceLineId", serviceLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
		}
		
		
		
		if(serviceLine.getServiceAttributes().getServiceType() != null && configurationLine.getServiceAttributes().getServiceType() !=null) {
			if(!serviceLine.getServiceAttributes().getServiceType().equals(configurationLine.getServiceAttributes().getServiceType()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "serviceAttributes", serviceLine.getServiceAttributes().getServiceType(), configurationLine.getServiceAttributes().getServiceType(), false));
			}
		}
		if(serviceLine.getServiceAttributes() != null && configurationLine.getServiceAttributes() ==null) {
			compareResults.add(createCompareResult(serviceLine.getItemName(), "serviceAttributes", serviceLine.getServiceAttributes().getServiceType(), configurationLine.getServiceAttributes().getServiceType(), false));
		}
		if(serviceLine.getServiceAttributes() == null && configurationLine.getServiceAttributes() !=null) {
			compareResults.add(createCompareResult(serviceLine.getItemName(), "serviceAttributes", serviceLine.getServiceAttributes().getServiceType(), configurationLine.getServiceAttributes().getServiceType(), false));
		}
		
		
		
		if(serviceLine.getItemType() != null && configurationLine.getItemType() !=null) 
		{
			if(!serviceLine.getItemType().equals(configurationLine.getItemType()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "itemType", serviceLine.getItemType(), configurationLine.getItemType(), false));
			}
		}
		if(serviceLine.getItemType() != null && configurationLine.getItemType() ==null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "itemType", serviceLine.getItemType(), configurationLine.getItemType(), false));
		}
		if(serviceLine.getItemType() == null && configurationLine.getItemType() !=null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "itemType", serviceLine.getItemType(), configurationLine.getItemType(), false));
		}
		
		
		
		if(serviceLine.getQuantity() != null && configurationLine.getQuantity() !=null) 
		{
			if(!serviceLine.getQuantity().equals(configurationLine.getQuantity()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "quantity", serviceLine.getQuantity(), configurationLine.getQuantity(), false));
			}
		}
		if(serviceLine.getQuantity() != null && configurationLine.getQuantity() ==null) 
		{
			compareResults.add(createCompareResult(serviceLine.getItemName(), "quantity", serviceLine.getQuantity(), configurationLine.getQuantity(), false));
		}
		if(serviceLine.getQuantity() == null && configurationLine.getQuantity() !=null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "quantity", serviceLine.getQuantity(), configurationLine.getQuantity(), false));
		}
		
		
		
		if(serviceLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice() !=null) 
		{
			if(!serviceLine.getUnitListPrice().equals(configurationLine.getPricingInformation().getUnitListPrice()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "unitListPrice", serviceLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
			}
		}
		if(serviceLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice() ==null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "unitListPrice", serviceLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
		}
		if(serviceLine.getUnitListPrice() == null && configurationLine.getPricingInformation().getUnitListPrice() !=null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "unitListPrice", serviceLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
		}
		
		
		
		
		if(serviceLine.getExtendedListPrice() != null && configurationLine.getPricingInformation().getExtendedListPrice() !=null) 
		{
			if(!serviceLine.getExtendedListPrice().equals(configurationLine.getPricingInformation().getExtendedListPrice()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "extendedListPrice", serviceLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
			}
		}
		if(serviceLine.getExtendedListPrice() != null && configurationLine.getPricingInformation().getExtendedListPrice() ==null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "extendedListPrice", serviceLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
		}
		if(serviceLine.getExtendedListPrice() == null && configurationLine.getPricingInformation().getExtendedListPrice() !=null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "extendedListPrice", serviceLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
		}
		
		
		
		if(serviceLine.getDescription() != null && configurationLine.getDescription() !=null) 
		{
			if(!serviceLine.getDescription().equals(configurationLine.getDescription()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "description", serviceLine.getDescription(), configurationLine.getDescription(), false));
			}
		}
		if(serviceLine.getDescription() != null && configurationLine.getDescription() ==null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "description", serviceLine.getDescription(), configurationLine.getDescription(), false));
		}
		if(serviceLine.getDescription() == null && configurationLine.getDescription() !=null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "description", serviceLine.getDescription(), configurationLine.getDescription(), false));
		}
		
		
		
		
		if(serviceLine.getLeadTime() != null && configurationLine.getLeadTime() !=null) 
		{
			if(!serviceLine.getLeadTime().equals(configurationLine.getLeadTime().getDuration()))
			{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "leadTime", serviceLine.getLeadTime(), configurationLine.getLeadTime().getDuration(), false));
			}
		}
		if(serviceLine.getLeadTime() != null && configurationLine.getLeadTime() ==null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "leadTime", serviceLine.getLeadTime(), configurationLine.getLeadTime(), false));
		}
		if(serviceLine.getLeadTime() == null && configurationLine.getLeadTime() !=null) 
		{
				compareResults.add(createCompareResult(serviceLine.getItemName(), "leadTime", serviceLine.getLeadTime(), configurationLine.getLeadTime(), false));
		}
		
	*/	
		
		
		return compareResults;
	}
	
	public static List<CompareResult> compareMinorLine(MinorLine minorLine,
			ConfigurationLine configurationLine) 
	{
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		
		if(minorLine.getConfigPath() != null && configurationLine.getConfigPath() !=null)
		{
			if(!minorLine.getConfigPath().equals(configurationLine.getConfigPath()))
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "ConfigPath", minorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		if(minorLine.getConfigPath() != null && configurationLine.getConfigPath() ==null)
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "ConfigPath", minorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		
		if(minorLine.getConfigPath() == null && configurationLine.getConfigPath() !=null)
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "ConfigPath", minorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		
	
		if(minorLine.getSelectionFlag() != null && configurationLine.getSelectionCode() !=null)
		{
			if(!minorLine.getSelectionFlag().equals(configurationLine.getSelectionCode() ))
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "SelectionCode", minorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		}
		if(minorLine.getSelectionFlag() != null && configurationLine.getSelectionCode() ==null)
			{
			compareResults.add(createCompareResult(minorLine.getItemName(), "SelectionCode", minorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		if(minorLine.getSelectionFlag() == null && configurationLine.getSelectionCode() !=null)
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "SelectionCode", minorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		
		
		
		if(minorLine.get_default() != null && configurationLine.getDefault_() !=null)
		{
			if(!minorLine.get_default().equals(configurationLine.getDefault_() ))
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "Default", minorLine.get_default(), configurationLine.getDefault_(), false));
			}
		}
		if(minorLine.get_default() != null && configurationLine.getDefault_() ==null)
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "Default", minorLine.get_default(), configurationLine.getDefault_(), false));
			}
		
		if(minorLine.get_default() == null && configurationLine.getDefault_() !=null)
			if(!minorLine.get_default().equals(configurationLine.getDefault_() ))
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "Default", minorLine.get_default(), configurationLine.getDefault_(), false));
			}
		
		
		
		if(minorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
    	{
    		if(minorLine.getProductAttributes().getSmartAccountRequiredconfig()!= null && configurationLine.getProductAttributes().getSmartAccountRequired()!=null)
    		{
    			if(!minorLine.getProductAttributes().getSmartAccountRequiredconfig().equals(configurationLine.getProductAttributes().getSmartAccountRequired()))
    			{
    				compareResults.add(createCompareResult(minorLine.getItemName(), "SmartAccountRequired", minorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
    			}	
    		}
    	}
		if(minorLine.getProductAttributes() != null && configurationLine.getProductAttributes() == null)
    	{
			compareResults.add(createCompareResult(minorLine.getItemName(), "SmartAccountRequired", minorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
    	}	
    	
		if(minorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null)
    	{
    		compareResults.add(createCompareResult(minorLine.getItemName(), "SmartAccountRequired", minorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
    	}	
    		
		
		if(minorLine.getItemType() != null && configurationLine.getItemType() !=null) 
		{
			if(!minorLine.getItemType().equals(configurationLine.getItemType()))
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "itemType", minorLine.getItemType(), configurationLine.getItemType(), false));
			}
		}
		if(minorLine.getItemType() != null && configurationLine.getItemType() == null) 
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "itemType", minorLine.getItemType(), configurationLine.getItemType(), false));
			}
		if(minorLine.getItemType() == null && configurationLine.getItemType() != null)
			{
				compareResults.add(createCompareResult(minorLine.getItemName(), "itemType", minorLine.getItemType(), configurationLine.getItemType(), false));
			}
		
		
		if(minorLine.getQuantity() != null && configurationLine.getQuantity()!=null)
		{
    		if (!minorLine.getQuantity().equals(configurationLine.getQuantity())) 
    		{
    			compareResults.add(createCompareResult(minorLine.getItemName(), "Quantity", minorLine.getQuantity(),configurationLine.getQuantity(), false));
    		}
    		if(minorLine.getQuantity() != null && configurationLine.getQuantity() == null) 
    			{
    			compareResults.add(createCompareResult(minorLine.getItemName(), "Quantity", minorLine.getQuantity(),configurationLine.getQuantity(), false));
    			}
        					
        		}
        		if(minorLine.getQuantity() == null && configurationLine.getQuantity()!= null) 
        		{
            			compareResults.add(createCompareResult(minorLine.getItemName(), "Quantity", minorLine.getQuantity(),configurationLine.getQuantity(), false));
            		}
        		
		

		    	if(minorLine.getUnitListPrice()!= null && configurationLine.getPricingInformation()!=null)
		    	{
		    		if(minorLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice()!=null)
		    		{
		    			if(!minorLine.getUnitListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getUnitListPrice().stripTrailingZeros()))
			    {
					compareResults.add(createCompareResult(minorLine.getItemName(), "UnitListPrice", minorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
				}
		    		}
		    	}
		    	if(minorLine.getUnitListPrice() != null && configurationLine.getPricingInformation()==null) 
		    	{
		    		compareResults.add(createCompareResult(minorLine.getItemName(), "UnitListPrice", minorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
		    	}
		    	if(minorLine.getUnitListPrice() == null && configurationLine.getPricingInformation()!=null) 
		    		{
				    	compareResults.add(createCompareResult(minorLine.getItemName(), "UnitListPrice", minorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
				  	}
		    
		

		    	if(minorLine.getExtendedListPrice()!= null && configurationLine.getPricingInformation()!=null)
		    	{
		    		if(minorLine.getExtendedListPrice() != null && configurationLine.getPricingInformation().getExtendedListPrice()!=null)
		    		{
		    			if(!minorLine.getExtendedListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getExtendedListPrice().stripTrailingZeros()))
		    			{
		    				compareResults.add(createCompareResult(minorLine.getItemName(), "ExtendedListPrice", minorLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
		    			}
		    		}
		    	}
		    	if(minorLine.getExtendedListPrice() != null && configurationLine.getPricingInformation()==null) 
		    		{
		    			compareResults.add(createCompareResult(minorLine.getItemName(), "ExtendedListPrice", minorLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
		    		}
				if(minorLine.getExtendedListPrice() == null && configurationLine.getPricingInformation()!=null) 
				    {
						compareResults.add(createCompareResult(minorLine.getItemName(), "ExtendedListPrice", minorLine.getExtendedListPrice(), configurationLine.getPricingInformation().getExtendedListPrice(), false));
					}
			    		
		    	
				if(minorLine.getDescription() != null && configurationLine.getDescription()!=null)
				{
		    		if (!minorLine.getDescription().equals(configurationLine.getDescription())) 
		    		{
		    			compareResults.add(createCompareResult(minorLine.getItemName(), "Description", minorLine.getDescription(),configurationLine.getDescription(), false));
		    		}
				}
			if(minorLine.getDescription() != null && configurationLine.getDescription() == null)
				{
					compareResults.add(createCompareResult(minorLine.getItemName(), "Description", minorLine.getDescription(),configurationLine.getDescription(), false));
				}
			if(minorLine.getDescription() == null && configurationLine.getDescription() != null)
				{
					compareResults.add(createCompareResult(minorLine.getItemName(), "Description", minorLine.getDescription(),configurationLine.getDescription(), false));
				}
		
			
			if(minorLine.getLeadTime() != null && configurationLine.getLeadTime()!=null) 
	    	{
	    		if (!minorLine.getLeadTime().equals(configurationLine.getLeadTime().getDuration()))
	    		{
	    			compareResults.add(createCompareResult(minorLine.getItemName(), "LeadTime",minorLine.getLeadTime(),	configurationLine.getLeadTime().getDuration(), false));
	    		}
		  }
	    
	    	if(minorLine.getLeadTime() != null && configurationLine.getLeadTime()==null) 
	    		{
	    			compareResults.add(createCompareResult(minorLine.getItemName(), "LeadTime",minorLine.getLeadTime(),	configurationLine.getLeadTime().getDuration(), false));
	    		}
		  
	    	if(minorLine.getLeadTime() == null && configurationLine.getLeadTime()!=null) 
	    		{
	    			compareResults.add(createCompareResult(minorLine.getItemName(), "LeadTime",minorLine.getLeadTime(),configurationLine.getLeadTime().getDuration(), false));
	    		}
		  
     

	    	if(minorLine.getServiceable() != null && configurationLine.getProductAttributes().getServiceable() !=null)
	    	{
				if(!minorLine.getServiceable().equals(configurationLine.getProductAttributes().getServiceable()))
				{
					compareResults.add(createCompareResult(minorLine.getItemName(), "serviceable", minorLine.getServiceable(), configurationLine.getProductAttributes().getServiceable(), false));
				}
			}
	    	if(minorLine.getServiceable() != null && configurationLine.getProductAttributes().getServiceable() ==null)
	    		{
	    			compareResults.add(createCompareResult(minorLine.getItemName(), "serviceable", minorLine.getServiceable(), configurationLine.getProductAttributes().getServiceable(), false));
				}
	
	    	if(minorLine.getServiceable() == null && configurationLine.getProductAttributes().getServiceable() !=null) 
	    		{
					compareResults.add(createCompareResult(minorLine.getItemName(), "serviceable", minorLine.getServiceable(), configurationLine.getProductAttributes().getServiceable(), false));
				}
			
		
	    	if(minorLine.getAllowedDifferentialDuration() != null && configurationLine.getProductAttributes().getAllowedDifferentialDuration() !=null)
	    	{
				if(!minorLine.getAllowedDifferentialDuration().equals(configurationLine.getProductAttributes().getAllowedDifferentialDuration()))
				{
					compareResults.add(createCompareResult(minorLine.getItemName(), "allowedDifferentialDuration", minorLine.getAllowedDifferentialDuration(), configurationLine.getProductAttributes().getAllowedDifferentialDuration(), false));
				}
			}
	    	if(minorLine.getAllowedDifferentialDuration() != null && configurationLine.getProductAttributes().getAllowedDifferentialDuration() ==null)
	    		{
					compareResults.add(createCompareResult(minorLine.getItemName(), "allowedDifferentialDuration", minorLine.getAllowedDifferentialDuration(), configurationLine.getProductAttributes().getAllowedDifferentialDuration(), false));
				}
			
	    	if(minorLine.getAllowedDifferentialDuration() == null && configurationLine.getProductAttributes().getAllowedDifferentialDuration() !=null)
	    		{
					compareResults.add(createCompareResult(minorLine.getItemName(), "allowedDifferentialDuration", minorLine.getAllowedDifferentialDuration(), configurationLine.getProductAttributes().getAllowedDifferentialDuration(), false));
				}
			

	    	if(minorLine.getSourceLineId() != null && configurationLine.getSourceLineID() !=null)
	    	{
				if(!minorLine.getSourceLineId().get(0).equals(configurationLine.getSourceLineID()))
				{
					compareResults.add(createCompareResult(minorLine.getItemName(), "sourceLineId",minorLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
				}
			}
	    	if(minorLine.getSourceLineId() != null && configurationLine.getSourceLineID() ==null) 
	    		{
					compareResults.add(createCompareResult(minorLine.getItemName(), "sourceLineId",minorLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
				}
	    	if(minorLine.getSourceLineId() == null && configurationLine.getSourceLineID() !=null)
	    		{
					compareResults.add(createCompareResult(minorLine.getItemName(), "sourceLineId",minorLine.getSourceLineId(), configurationLine.getSourceLineID(), false));
	    		}
		
		
		
    	
		
		
		
		
		return compareResults;
	}

	
	public static List<CompareResult> compareXaasMinorLine(XaasMinorLine xaasMinorLine,	ConfigurationLine configurationLine) {
		List<CompareResult> compareResults = new ArrayList<CompareResult>();	
		if(xaasMinorLine.getActionTag() != null && configurationLine.getXaasAttributes().getActionCode() !=null) {
			if(!xaasMinorLine.getActionTag().equals(configurationLine.getXaasAttributes().getActionCode())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Action Code", xaasMinorLine.getActionTag(), configurationLine.getXaasAttributes().getActionCode(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName()+ "Action Code"+ xaasMinorLine.getActionTag()+ configurationLine.getXaasAttributes().getActionCode());
		}
		if(xaasMinorLine.getActionTag() != null && configurationLine.getXaasAttributes().getActionCode() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Action Code", xaasMinorLine.getActionTag(), configurationLine.getXaasAttributes().getActionCode(), false));
		}
		if(xaasMinorLine.getActionTag() == null && configurationLine.getXaasAttributes().getActionCode() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Action Code", xaasMinorLine.getActionTag(), configurationLine.getXaasAttributes().getActionCode(), false));
		}
		
		if(xaasMinorLine.getXaasTermPayment().getRequestedStartDate() != null && configurationLine.getXaasAttributes().getRequestedStartDate() !=null) {
			if(!xaasMinorLine.getXaasTermPayment().getRequestedStartDate().equals(configurationLine.getXaasAttributes().getRequestedStartDate())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Requested Start Date", xaasMinorLine.getXaasTermPayment().getRequestedStartDate(), configurationLine.getXaasAttributes().getRequestedStartDate(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName()+ "Requested Start Date"+ xaasMinorLine.getXaasTermPayment().getRequestedStartDate()+ configurationLine.getXaasAttributes().getRequestedStartDate());
		}
		if(xaasMinorLine.getXaasTermPayment().getRequestedStartDate() != null && configurationLine.getXaasAttributes().getRequestedStartDate() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Requested Start Date", xaasMinorLine.getXaasTermPayment().getRequestedStartDate(), configurationLine.getXaasAttributes().getRequestedStartDate(), false));
		}
		if(xaasMinorLine.getXaasTermPayment().getRequestedStartDate() == null && configurationLine.getXaasAttributes().getRequestedStartDate() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Requested Start Date", xaasMinorLine.getXaasTermPayment().getRequestedStartDate(), configurationLine.getXaasAttributes().getRequestedStartDate(), false));
		}
		
		if(xaasMinorLine.getXaasTermPayment().getEndDate() != null && configurationLine.getXaasAttributes().getRequestedEndDate() !=null) {
			if(!xaasMinorLine.getXaasTermPayment().getEndDate().equals(configurationLine.getXaasAttributes().getRequestedEndDate())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Requested End Date", xaasMinorLine.getXaasTermPayment().getEndDate(), configurationLine.getXaasAttributes().getRequestedEndDate(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName()+ "Requested End Date"+ xaasMinorLine.getXaasTermPayment().getEndDate()+ configurationLine.getXaasAttributes().getRequestedEndDate());
		}
		if(xaasMinorLine.getXaasTermPayment().getEndDate() != null && configurationLine.getXaasAttributes().getRequestedEndDate() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Requested End Date", xaasMinorLine.getXaasTermPayment().getEndDate(), configurationLine.getXaasAttributes().getRequestedEndDate(), false));
		}
		if(xaasMinorLine.getXaasTermPayment().getEndDate() == null && configurationLine.getXaasAttributes().getRequestedEndDate() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Requested End Date", xaasMinorLine.getXaasTermPayment().getEndDate(), configurationLine.getXaasAttributes().getRequestedEndDate(), false));
		}
		
		
		if(xaasMinorLine.getXaasTermPayment().getPrepayTerm() != null && configurationLine.getXaasAttributes().getPrepayTerm() !=null) {
			if(!xaasMinorLine.getXaasTermPayment().getPrepayTerm().equals(configurationLine.getXaasAttributes().getPrepayTerm())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Initial Term", xaasMinorLine.getXaasTermPayment().getPrepayTerm(), configurationLine.getXaasAttributes().getPrepayTerm(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName()+ "Initial Term"+ xaasMinorLine.getXaasTermPayment().getPrepayTerm()+ configurationLine.getXaasAttributes().getPrepayTerm());
		}
		if(xaasMinorLine.getXaasTermPayment().getPrepayTerm() != null && configurationLine.getXaasAttributes().getRequestedEndDate() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Initial Term", xaasMinorLine.getXaasTermPayment().getPrepayTerm(), configurationLine.getXaasAttributes().getPrepayTerm(), false));
		}
		if(xaasMinorLine.getXaasTermPayment().getPrepayTerm() == null && configurationLine.getXaasAttributes().getRequestedEndDate() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Initial Term", xaasMinorLine.getXaasTermPayment().getPrepayTerm(), configurationLine.getXaasAttributes().getPrepayTerm(), false));
		}
		
		if(xaasMinorLine.getXaasTermPayment().getPrepayTerm() != null && configurationLine.getXaasAttributes().getPrepayTerm() !=null) {
			if(!xaasMinorLine.getXaasTermPayment().getPrepayTerm().equals(configurationLine.getXaasAttributes().getPrepayTerm())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "PrePay Term", xaasMinorLine.getXaasTermPayment().getPrepayTerm(), configurationLine.getXaasAttributes().getPrepayTerm(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName() + "PrePay Term" + xaasMinorLine.getXaasTermPayment().getPrepayTerm() + configurationLine.getXaasAttributes().getPrepayTerm());
		}
		if(xaasMinorLine.getXaasTermPayment().getPrepayTerm() != null && configurationLine.getXaasAttributes().getRequestedEndDate() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "PrePay Term", xaasMinorLine.getXaasTermPayment().getPrepayTerm(), configurationLine.getXaasAttributes().getPrepayTerm(), false));
		}
		if(xaasMinorLine.getXaasTermPayment().getPrepayTerm() == null && configurationLine.getXaasAttributes().getRequestedEndDate() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "PrePay Term", xaasMinorLine.getXaasTermPayment().getPrepayTerm(), configurationLine.getXaasAttributes().getPrepayTerm(), false));
		}
		
		if(xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm() != null && configurationLine.getXaasAttributes().getAutoRenewalTerm() !=null) {
			if(!xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm().equals(configurationLine.getXaasAttributes().getAutoRenewalTerm())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "AutoRenewal Term", xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm(), configurationLine.getXaasAttributes().getAutoRenewalTerm(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName() + "AutoRenewal Term" + xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm() + configurationLine.getXaasAttributes().getAutoRenewalTerm());
		}
		if(xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm() != null && configurationLine.getXaasAttributes().getRequestedEndDate() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "AutoRenewal Term", xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm(), configurationLine.getXaasAttributes().getAutoRenewalTerm(), false));
		}
		if(xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm() == null && configurationLine.getXaasAttributes().getRequestedEndDate() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "AutoRenewal Term", xaasMinorLine.getXaasTermPayment().getAutoRenewalTerm(), configurationLine.getXaasAttributes().getAutoRenewalTerm(), false));
		}
		
		if(xaasMinorLine.getXaasTermPayment().getBillingModel() != null && configurationLine.getXaasAttributes().getBillingModel() !=null) {
			if(!xaasMinorLine.getXaasTermPayment().getBillingModel().equals(configurationLine.getXaasAttributes().getBillingModel())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Billing Model", xaasMinorLine.getXaasTermPayment().getBillingModel(), configurationLine.getXaasAttributes().getBillingModel(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName()+ "Billing Model"+ xaasMinorLine.getXaasTermPayment().getBillingModel()+ configurationLine.getXaasAttributes().getBillingModel());
		}
		if(xaasMinorLine.getXaasTermPayment().getBillingModel() != null && configurationLine.getXaasAttributes().getRequestedEndDate() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Billing Model", xaasMinorLine.getXaasTermPayment().getBillingModel(), configurationLine.getXaasAttributes().getBillingModel(), false));
		}
		if(xaasMinorLine.getXaasTermPayment().getBillingModel() == null && configurationLine.getXaasAttributes().getRequestedEndDate() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Billing Model", xaasMinorLine.getXaasTermPayment().getBillingModel(), configurationLine.getXaasAttributes().getBillingModel(), false));
		}
		
		if(xaasMinorLine.getUsageQuantity() != null && configurationLine.getXaasAttributes().getUsageQuantity() !=null) {
			if(!xaasMinorLine.getUsageQuantity().equals(configurationLine.getXaasAttributes().getUsageQuantity())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Usage Quantity", xaasMinorLine.getUsageQuantity(), configurationLine.getXaasAttributes().getUsageQuantity(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName() + "Usage Quantity" +  xaasMinorLine.getUsageQuantity() + configurationLine.getXaasAttributes().getUsageQuantity());
		}
		if(xaasMinorLine.getUsageQuantity() != null && configurationLine.getXaasAttributes().getUsageQuantity() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Usage Quantity", xaasMinorLine.getUsageQuantity(), configurationLine.getXaasAttributes().getUsageQuantity(), false));
		}
		if(xaasMinorLine.getUsageQuantity() == null && configurationLine.getXaasAttributes().getUsageQuantity() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Usage Quantity", xaasMinorLine.getUsageQuantity(), configurationLine.getXaasAttributes().getUsageQuantity(), false));
		}
		
		if(xaasMinorLine.getChargeType() != null && configurationLine.getXaasAttributes().getChargeType() !=null) {
			if(!xaasMinorLine.getChargeType().equals(configurationLine.getXaasAttributes().getChargeType())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Charge Type", xaasMinorLine.getChargeType(), configurationLine.getXaasAttributes().getChargeType(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName() + "Charge Type" +  xaasMinorLine.getChargeType() + configurationLine.getXaasAttributes().getChargeType());
		}
		if(xaasMinorLine.getChargeType() != null && configurationLine.getXaasAttributes().getChargeType() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Charge Type", xaasMinorLine.getChargeType(), configurationLine.getXaasAttributes().getChargeType(), false));
		}
		if(xaasMinorLine.getChargeType() == null && configurationLine.getXaasAttributes().getChargeType() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Charge Type", xaasMinorLine.getChargeType(), configurationLine.getXaasAttributes().getChargeType(), false));
		}
		
		if(xaasMinorLine.getBillingType() != null && configurationLine.getXaasAttributes().getBillingType() !=null) {
			if(!xaasMinorLine.getBillingType().equals(configurationLine.getXaasAttributes().getBillingType())){
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Billing Type", xaasMinorLine.getBillingType(), configurationLine.getXaasAttributes().getBillingType(), false));
			}
			else
				System.out.println(xaasMinorLine.getItemName()+ "Billing Type"+ xaasMinorLine.getBillingType()+ configurationLine.getXaasAttributes().getBillingType());
		}
		if(xaasMinorLine.getBillingType() != null && configurationLine.getXaasAttributes().getBillingType() == null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Billing Type", xaasMinorLine.getBillingType(), configurationLine.getXaasAttributes().getBillingType(), false));
		}
		if(xaasMinorLine.getBillingType() == null && configurationLine.getXaasAttributes().getBillingType() !=null) {
				compareResults.add(createCompareResult(xaasMinorLine.getItemName(), "Billing Type", xaasMinorLine.getBillingType(), configurationLine.getXaasAttributes().getBillingType(), false));
		}
		


		return compareResults;
	}

	private static CompareResult createCompareResult(String itemName, String propertyName, Object value1, Object value2,
			boolean result) {
		CompareResult compareResult = new CompareResult();
		compareResult.setItemName(itemName);
		compareResult.setPropertyName(propertyName);
		compareResult.setConfigValue(value1);
		compareResult.setB2bValue(value2);
		compareResult.setResult(false);
		return compareResult;
	}
}
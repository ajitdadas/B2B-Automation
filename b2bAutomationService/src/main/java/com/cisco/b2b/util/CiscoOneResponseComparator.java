package com.cisco.b2b.util;

import java.util.ArrayList;
import java.util.List;

import com.cisco.b2b.model.Address;
import com.cisco.b2b.model.Attribute;
import com.cisco.b2b.model.B2BResponse;
import com.cisco.b2b.model.ConfigResponse;
import com.cisco.b2b.model.ConfigurationLine;
import com.cisco.b2b.model.InstallSiteLocation;
import com.cisco.b2b.model.MajorLine;
import com.cisco.b2b.model.Message;
import com.cisco.b2b.model.MinorLine;
import com.cisco.b2b.model.ServiceLine;

public class CiscoOneResponseComparator {
	
	public static List<CompareResult> compareResponse(ConfigResponse configResponse, B2BResponse b2bResponse){
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		List<MajorLine> majorLines = configResponse.getMajorLine() != null && !configResponse.getMajorLine().isEmpty() ? configResponse.getMajorLine()  : new ArrayList<MajorLine>();
		List<ConfigurationLine> parentLines = new ArrayList<>(); 
		List<ConfigurationLine> serviceLinesB2B = new ArrayList<>();
		List<ConfigurationLine> minorLines = new ArrayList<>();
		for(ConfigurationLine configurationLine :  b2bResponse.getConfigurationLine()) {
			if(configurationLine.getParentID().equals("0")) {
				parentLines.add(configurationLine);
			}
			else if(configurationLine.getParentID().equals("1") && configurationLine.getItemType().equals("SERVICE")) {
				serviceLinesB2B.add(configurationLine);
			}
			else if(!configurationLine.getParentID().equals("0") && (configurationLine.getItemType().equals("CONFIGURABLE") || configurationLine.getItemType().equals("NONCONFIGURABLE"))) {
		        minorLines.add(configurationLine);
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
					//majorLine=serLineConfigIterator;
					//compareResults.addAll(compareServiceLine(serLineConfigIterator,configurationLine));
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
			
		}
		
	
		return compareResults;
	}
	
	public static List<CompareResult> compareConfigMajorLineResponse(MajorLine majorLine,
			ConfigurationLine configurationLine) {
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		{
		if(majorLine.getBundleFlag() != null && configurationLine.getProductAttributes().getBundleFlag() !=null) {
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		if(majorLine.getBundleFlag() != null && configurationLine.getProductAttributes().getBundleFlag() == null) {
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		if(majorLine.getBundleFlag() == null && configurationLine.getProductAttributes().getBundleFlag() != null) {
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		}
		
		
	    {
	    	if(majorLine.getConfigPath() != null && configurationLine.getConfigPath()!=null) {
			if(!majorLine.getConfigPath().equals(configurationLine.getConfigPath()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "Config Path", majorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		if(majorLine.getConfigPath() != null && configurationLine.getConfigPath() == null) {
			if(!majorLine.getConfigPath().equals(configurationLine.getConfigPath()))
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Config Path", majorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		if(majorLine.getConfigPath() == null && configurationLine.getConfigPath() != null) {
			if(!majorLine.getConfigPath().equals(configurationLine.getConfigPath())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Config Path", majorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		}
	    
	    {
	    	if(majorLine.getSelectionFlag() != null && configurationLine.getSelectionCode()!=null) {
			if(!majorLine.getSelectionFlag().equals(configurationLine.getSelectionCode()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "SelectionCode", majorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		}
		if(majorLine.getSelectionFlag() != null && configurationLine.getSelectionCode() == null) {
			if(!majorLine.getSelectionFlag().equals(configurationLine.getSelectionCode()))
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "SelectionCode", majorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		}
		if(majorLine.getSelectionFlag() == null && configurationLine.getSelectionCode() != null) {
			if(!majorLine.getSelectionFlag().equals(configurationLine.getSelectionCode())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "SelectionCode", majorLine.getSelectionFlag(), configurationLine.getSelectionCode(), false));
			}
		}
		}
	    
	    
	    {
	    	if(majorLine.getStatus() != null && configurationLine.getStatus()!=null) {
			if(!majorLine.getStatus().equals(configurationLine.getStatus()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "Status", majorLine.getStatus(), configurationLine.getStatus(), false));
			}
		}
		if(majorLine.getStatus() != null && configurationLine.getStatus() == null) {
			if(!majorLine.getStatus().equals(configurationLine.getStatus()))
			{
				compareResults.add(createCompareResult(majorLine.getItemName(), "Status", majorLine.getStatus(), configurationLine.getStatus(), false));
			}
		}
		if(majorLine.getStatus() == null && configurationLine.getStatus() != null) {
			if(!majorLine.getStatus().equals(configurationLine.getStatus())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Status", majorLine.getStatus(), configurationLine.getStatus(), false));
			}
		}
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
	    
	     {
	    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
	    	{
	    		if(majorLine.getProductAttributes().gettAAFlag() != null && configurationLine.getProductAttributes().gettAAIndicator()!=null) {
			if(!majorLine.getProductAttributes().gettAAFlag().equals(configurationLine.getProductAttributes().gettAAIndicator()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "TAAIndicator", majorLine.getProductAttributes().gettAAFlag(), configurationLine.getProductAttributes().gettAAIndicator(), false));
			}
	    		}
	    	}
	    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()==null) 
	    	{
	    		if(majorLine.getProductAttributes().gettAAFlag() != null && configurationLine.getProductAttributes().gettAAIndicator()!=null) {
			if(!majorLine.getProductAttributes().gettAAFlag().equals(configurationLine.getProductAttributes().gettAAIndicator()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "TAAIndicator", majorLine.getProductAttributes().gettAAFlag(), configurationLine.getProductAttributes().gettAAIndicator(), false));
			}
	    		}
	    	}
	    	if(majorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null) 
	    	{
	    		if(majorLine.getProductAttributes().gettAAFlag() != null && configurationLine.getProductAttributes().gettAAIndicator()!=null) {
			if(!majorLine.getProductAttributes().gettAAFlag().equals(configurationLine.getProductAttributes().gettAAIndicator()))
		    {
				compareResults.add(createCompareResult(majorLine.getItemName(), "TAAIndicator", majorLine.getProductAttributes().gettAAFlag(), configurationLine.getProductAttributes().gettAAIndicator(), false));
			}
	    		}
	    	}
	   }
			
	     
	     {
		    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
		    	{
		    		if(majorLine.getProductAttributes().gettEPFlag()!= null && configurationLine.getProductAttributes().gettEPIndicator()!=null) {
				if(!majorLine.getProductAttributes().gettEPFlag().equals(configurationLine.getProductAttributes().gettEPIndicator()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "TEPIndicator", majorLine.getProductAttributes().gettEPFlag(), configurationLine.getProductAttributes().gettEPIndicator(), false));
				}
		    		}
		    	}
		    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()==null) 
		    	{
		    		if(majorLine.getProductAttributes().gettEPFlag() != null && configurationLine.getProductAttributes().gettEPIndicator()!=null) {
				if(!majorLine.getProductAttributes().gettEPFlag().equals(configurationLine.getProductAttributes().gettEPIndicator()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "TEPIndicator", majorLine.getProductAttributes().gettEPFlag(), configurationLine.getProductAttributes().gettEPIndicator(), false));
				}
		    		}
		    	}
		    	if(majorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null) 
		    	{
		    		if(majorLine.getProductAttributes().gettEPFlag() != null && configurationLine.getProductAttributes().gettEPIndicator()!=null) {
				if(!majorLine.getProductAttributes().gettEPFlag().equals(configurationLine.getProductAttributes().gettEPIndicator()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "TEPIndicator", majorLine.getProductAttributes().gettEPFlag(), configurationLine.getProductAttributes().gettEPIndicator(), false));
				}
		    		}
		    	}
		   }
		
	     
	     
	     {
		    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()!=null)
		    	{
		    		if(majorLine.getProductAttributes().getSmartAccountRequiredconfig()!= null && configurationLine.getProductAttributes().getSmartAccountRequired()!=null) {
				if(!majorLine.getProductAttributes().getSmartAccountRequiredconfig().equals(configurationLine.getProductAttributes().getSmartAccountRequired()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "SmartAccountRequired", majorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
				}
		    		}
		    	}
		    	if(majorLine.getProductAttributes() != null && configurationLine.getProductAttributes()==null) 
		    	{
		    		if(majorLine.getProductAttributes().getSmartAccountRequiredconfig() != null && configurationLine.getProductAttributes().getSmartAccountRequired()!=null) {
				if(!majorLine.getProductAttributes().getSmartAccountRequiredconfig().equals(configurationLine.getProductAttributes().getSmartAccountRequired()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "SmartAccountRequired", majorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
				}
		    		}
		    	}
		    	if(majorLine.getProductAttributes() == null && configurationLine.getProductAttributes()!=null) 
		    	{
		    		if(majorLine.getProductAttributes().getSmartAccountRequiredconfig() != null && configurationLine.getProductAttributes().getSmartAccountRequired()!=null) {
				if(!majorLine.getProductAttributes().getSmartAccountRequiredconfig().equals(configurationLine.getProductAttributes().getSmartAccountRequired()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "SmartAccountRequired", majorLine.getProductAttributes().getSmartAccountRequiredconfig(), configurationLine.getProductAttributes().getSmartAccountRequired(), false));
				}
		    		}
		    	}
		   }
		
	     
	     
	    {
		    	if(majorLine.getItemType() != null && configurationLine.getItemType()!=null) {
		    		if (!majorLine.getItemType().equals(configurationLine.getItemType())) {
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),
		    					configurationLine.getItemType(), false));
		    		}
			}
			if(majorLine.getItemType() != null && configurationLine.getItemType() == null) {
				if (!majorLine.getItemType().equals(configurationLine.getItemType())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),
							configurationLine.getItemType(), false));
				}
			}
			if(majorLine.getItemType() == null && configurationLine.getItemType() != null) {
				if (!majorLine.getItemType().equals(configurationLine.getItemType())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),
							configurationLine.getItemType(), false));
				}
			}
		}
	     
	     
	     {
		    	if(majorLine.getQuantity() != null && configurationLine.getQuantity()!=null) {
		    		if (!majorLine.getQuantity().equals(configurationLine.getQuantity())) {
		    			compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),
		    					configurationLine.getQuantity(), false));
		    		}
			}
			if(majorLine.getQuantity() != null && configurationLine.getQuantity() == null) {
				if (!majorLine.getQuantity().equals(configurationLine.getQuantity())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),
							configurationLine.getQuantity(), false));
				}
			}
			if(majorLine.getQuantity() == null && configurationLine.getQuantity() != null) {
				if (!majorLine.getQuantity().equals(configurationLine.getQuantity())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),
							configurationLine.getQuantity(), false));
				}
			}
		}
	     
	     
	     {
		    	if(majorLine.getUnitListPrice()!= null && configurationLine.getPricingInformation()!=null)
		    	{
		    		if(majorLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice()!=null) {
				if(!majorLine.getUnitListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getUnitListPrice().stripTrailingZeros()))
			    {
					compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice", majorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
				}
		    		}
		    	}
		    	if(majorLine.getUnitListPrice() != null && configurationLine.getPricingInformation()==null) 
		    	{
		    		if(majorLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice()!=null) {
						if(!majorLine.getUnitListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getUnitListPrice().stripTrailingZeros()))
					    {
							compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice", majorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
						}
				    		}
		    	}
		    	if(majorLine.getUnitListPrice() == null && configurationLine.getPricingInformation()!=null) 
		    	{
		    		if(majorLine.getUnitListPrice() != null && configurationLine.getPricingInformation().getUnitListPrice()!=null) {
					if(!majorLine.getUnitListPrice().stripTrailingZeros().equals(configurationLine.getPricingInformation().getUnitListPrice().stripTrailingZeros()))
				    {
						compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice", majorLine.getUnitListPrice(), configurationLine.getPricingInformation().getUnitListPrice(), false));
					}
			    		}
		    	}
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
	     
	         System.out.println(majorLine.getSourceLineId());
	         System.out.println(configurationLine.getSourceLineID());
		    	
		    	
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
			//if(!serviceLine.getServiceLevelName().equals(configurationLine.getServiceAttributes().getServiceLevelName())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "ServiceLevelName", serviceLine.getServiceLevelName(), configurationLine.getItemName(), false));
			
		}
		if(serviceLine.getServiceLevelName() == null && configurationLine.getServiceAttributes().getServiceLevelName() !=null) {
			//if(!serviceLine.getServiceLevelName().equals(configurationLine.getServiceAttributes().getServiceLevelName())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "ServiceLevelName", serviceLine.getItemName(), configurationLine.getServiceAttributes().getServiceLevelName(), false));
			
		}
		
		if(serviceLine.getDurationListPrice() != null && configurationLine.getPricingInformation().getDurationListPrice() !=null) {
			if(!serviceLine.getDurationListPrice().equals(configurationLine.getPricingInformation().getDurationListPrice())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "Duration List Price", serviceLine.getDurationListPrice(), configurationLine.getPricingInformation().getDurationListPrice(), false));
			}
		}
		if(serviceLine.getDurationListPrice() != null && configurationLine.getPricingInformation().getDurationListPrice() ==null) {
			//if(!serviceLine.getDurationListPrice().equals(configurationLine.getPricingInformation().getDurationListPrice())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "Duration List Price", serviceLine.getDurationListPrice(), configurationLine.getPricingInformation().getDurationListPrice(), false));
			
		}
		if(serviceLine.getDurationListPrice() == null && configurationLine.getPricingInformation().getDurationListPrice() !=null) {
			//if(!serviceLine.getDurationListPrice().equals(configurationLine.getPricingInformation().getDurationListPrice())){
				compareResults.add(createCompareResult(serviceLine.getItemName(), "Duration List Price", serviceLine.getDurationListPrice(), configurationLine.getPricingInformation().getDurationListPrice(), false));
			
		}
		
	
		
		return compareResults;
	}
	
	public static List<CompareResult> compareMinorLine(MinorLine minorLine,
			ConfigurationLine configurationLine) {
		List<CompareResult> compareResults = new ArrayList<CompareResult>();	
		if(minorLine.getConfigPath() != null && configurationLine.getConfigPath() !=null) {
			if(!minorLine.getConfigPath().equals(configurationLine.getConfigPath())){
				compareResults.add(createCompareResult(minorLine.getItemName(), "ConfigPath", minorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		if(minorLine.getConfigPath() != null && configurationLine.getConfigPath() ==null) {
			if(!minorLine.getConfigPath().equals(configurationLine.getConfigPath())){
				compareResults.add(createCompareResult(minorLine.getItemName(), "ConfigPath", minorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
		}
		if(minorLine.getConfigPath() == null && configurationLine.getConfigPath() !=null) {
			if(!minorLine.getConfigPath().equals(configurationLine.getConfigPath())){
				compareResults.add(createCompareResult(minorLine.getItemName(), "ConfigPath", minorLine.getConfigPath(), configurationLine.getConfigPath(), false));
			}
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

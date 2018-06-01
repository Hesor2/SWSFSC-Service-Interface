package com.swsfsc.service.service_interface.models;

public class Admin extends User
{
	private String payment_information;

	public String getPayment_information()
	{
		return payment_information;
	}

	public void setPayment_information(String payment_information)
	{
		this.payment_information = payment_information;
	}

}

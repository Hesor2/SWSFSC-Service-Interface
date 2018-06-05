package com.swsfsc.service.service_interface.models;

import java.util.Collection;

public class PendingPayments
{
	private Collection<PendingPayment> pendingPayments;
	
	public PendingPayments(Collection<PendingPayment> pendingPayments)
	{
		this.pendingPayments = pendingPayments;
	}

	public Collection<PendingPayment> getPendingPayments()
	{
		return pendingPayments;
	}
}

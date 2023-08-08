package com.tollpayment.payload.request;

import jakarta.validation.constraints.NotBlank;

public class PaymentRequest {

	@NotBlank
	private String id;
	@NotBlank
	private String transaction_time;

	@NotBlank
	private String transaction_status;

	public String getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}

	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

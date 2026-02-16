package com.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "cloud_vendor_info")
@Schema(description = "This table holds cloud vendor information.")
public class CloudVendor {
    @Id
    @Schema(description = "This is a Cloud Vendor Id. It shall be unique.")
    private String vendorId;
    @NotBlank(message = "Vendor Name is mandatory")
    private String vendorName;
    @NotBlank(message = "Vendor Address is mandatory")
    private String vendorAddress;
    @NotBlank(message = "Phone Number is mandatory")
    private String vendorPhoneNumber;

    public CloudVendor() {
    }

    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CloudVendor that = (CloudVendor) o;
        return java.util.Objects.equals(vendorId, that.vendorId) &&
                java.util.Objects.equals(vendorName, that.vendorName) &&
                java.util.Objects.equals(vendorAddress, that.vendorAddress) &&
                java.util.Objects.equals(vendorPhoneNumber, that.vendorPhoneNumber);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(vendorId, vendorName, vendorAddress, vendorPhoneNumber);
    }
}

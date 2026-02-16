package com.restapi.service.impl;

import com.restapi.exception.CloudVendorNotFoundException;
import com.restapi.model.CloudVendor;
import com.restapi.repository.CloudVendorRepository;
import com.restapi.service.CloudVendorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    private final CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public CloudVendor createCloudVendor(CloudVendor cloudVendor) {
        if (cloudVendor == null) {
            throw new IllegalArgumentException("CloudVendor cannot be null");
        }
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public CloudVendor updateCloudVendor(CloudVendor cloudVendor) {
        String vendorId = cloudVendor.getVendorId();
        if (vendorId == null || cloudVendorRepository.findById(vendorId).isEmpty()) {
            throw new CloudVendorNotFoundException(
                    "Cloud Vendor with ID " + (vendorId != null ? vendorId : "null") + " not found for update.");
        }
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void deleteCloudVendor(String cloudVendorId) {
        if (cloudVendorId == null || !cloudVendorRepository.existsById(cloudVendorId)) {
            throw new CloudVendorNotFoundException(
                    "Cloud Vendor with ID " + cloudVendorId + " not found for deletion.");
        }
        cloudVendorRepository.deleteById(cloudVendorId);
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if (cloudVendorId == null) {
            throw new CloudVendorNotFoundException("Cloud Vendor ID cannot be null");
        }
        return cloudVendorRepository.findById(cloudVendorId)
                .orElseThrow(() -> new CloudVendorNotFoundException("Requested Cloud Vendor does not exist"));
    }

    @Override
    public Page<CloudVendor> getAllCloudVendors(int page, int size) {
        return cloudVendorRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<CloudVendor> getByVendorName(String vendorName, int page, int size) {
        return cloudVendorRepository.findByVendorName(vendorName, PageRequest.of(page, size));
    }
}

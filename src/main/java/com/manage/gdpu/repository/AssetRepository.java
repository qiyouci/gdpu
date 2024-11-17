package com.manage.gdpu.repository;
import com.manage.gdpu.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssetRepository extends JpaRepository<Asset, String> {

    @Query("SELECT a FROM Asset a WHERE a.assetNumber =?1")
    Asset findByAssetNumber(String assetNumber);
}
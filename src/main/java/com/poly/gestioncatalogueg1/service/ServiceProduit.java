package com.poly.gestioncatalogueg1.service;

import com.poly.gestioncatalogueg1.dao.ProduitRepository;
import com.poly.gestioncatalogueg1.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit {
    ProduitRepository produitRepository;
    @Override
    public void saveProduct(Produit p) {
         produitRepository.save(p);
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProductsByMC(String mc) {
        return produitRepository.findByNomContains(mc);
    }

    @Override
    public List<Produit> getProductsBCat(Long idCat) {
        return produitRepository.getProductsBYCat(idCat);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduct(Long id) {
        return produitRepository.findById(id).orElse(null);
    }
}

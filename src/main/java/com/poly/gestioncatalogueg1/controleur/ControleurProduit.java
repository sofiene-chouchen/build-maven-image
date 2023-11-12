package com.poly.gestioncatalogueg1.controleur;

import com.poly.gestioncatalogueg1.entities.Produit;
import com.poly.gestioncatalogueg1.service.ServiceCategorie;
import com.poly.gestioncatalogueg1.service.ServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //api on utilise RestController
@AllArgsConstructor
public class ControleurProduit {
  ServiceProduit serviceProduit;
  ServiceCategorie serviceCategorie;

  @GetMapping("/index")
  public String getAllProducts(Model m, @RequestParam(defaultValue = "") String mc) {
//        List<Produit> l=serviceProduit.getAllProducts();
    List<Produit> l = serviceProduit.getProductsByMC(mc);
    m.addAttribute("product", l);

    return "vue";
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable Long id) {
    serviceProduit.deleteProduct(id);
    return "redirect:/index";
  }


  @GetMapping("/formajout")
  public String addProduct(Model m) {

    m.addAttribute("categories", serviceCategorie.getAllCategories());
    return "form";
  }

}

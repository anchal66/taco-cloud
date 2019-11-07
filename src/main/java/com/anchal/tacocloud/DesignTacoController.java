package com.anchal.tacocloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.anchal.tacocloud.Indegrediants;
import com.anchal.tacocloud.Indegrediants.Type;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String ShowDesignForm(Model model){
        List<Indegrediants> indegrediants = Arrays.asList(
                new Indegrediants("FLTO", "Flour Tortilla", Type.WRAP ),
                new Indegrediants("COTO", "Corn Tortilla", Type.WRAP),
                new Indegrediants("GRBF", "Ground Beef", Type.PROTEIN),
                new Indegrediants("CARN", "Carnitas", Type.PROTEIN),
                new Indegrediants("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Indegrediants("LETC", "Lettuce", Type.VEGGIES),
                new Indegrediants("CHED", "Cheddar", Type.CHEESE),
                new Indegrediants("JACK", "Monterrey Jack", Type.CHEESE),
                new Indegrediants("SLSA", "Salsa", Indegrediants.Type.SAUCE),
                new Indegrediants("SRCR", "Sour Cream", Indegrediants.Type.SAUCE)
        );
        Type[] types=Indegrediants.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(indegrediants,type));
        }
        model.addAttribute("design", new TacoCloudApplication());
        return "design";
    }
}

package cz.upce.fei.nnpia.cviceni.controllers;

import org.springframework.web.bind.annotation.*;

/*
* Controller
*       - odbavuje HTTP požadavky aplikace, typicky vrací View,
*         který zajistí vykreslení stránky
* RestController
*       - speciální typ Controlleru, který odbavuje REST požadavky
*         aplikace, vrací ResponseBody, který obsahuje data ve formátu
*         třeba JSON nebo XML
*/

/*
* YAML - nepoužívá uvozovky pro řetězce nebo klíče, dvojtečka pro přiřazení hodnoty nebo řetězení klíčů, nové řádky a odsazení oddělují řetězení nebo tvoří seznam objektů
* JSON - JSON objekty ohraničené {}, seznam vytvořen pomocí [], dvojtečka pro přizení hodnoty ke klíči, klíče jsou řetězce v uvozovkách, hodnoty a objekty jsou oddělené čárkou
* XML - velmi podobný zápis jako HTMl, klíče jsou tagy v závorkách <>, mezi tagy jsou pak hodnoty nebo množina dalších tagů, ty pak tvoří objekt
*/
@RestController
public class HelloController {

    @GetMapping("")
    public String helloWorld(){
        return "Hello World from Spring Boot application.";
    }

    @GetMapping("/{query}")
    public String getMappingParameter(@PathVariable String query) {
        return "[EP1] Received input: " + query;
    }

    @RequestMapping(value = "/get/{query}", method = RequestMethod.GET)
    public String requestMappingWithGetMethod(@PathVariable String query) {
        return "[EP2] Received input: " + query;
    }

    @GetMapping("/query")
    public String getMappingRequestParameter(@RequestParam String query) {
        return "[EP3] Received input: " + query;
    }

}

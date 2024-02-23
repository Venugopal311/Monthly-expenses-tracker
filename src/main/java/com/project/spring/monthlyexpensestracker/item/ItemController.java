package com.project.spring.monthlyexpensestracker.item;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
@SessionAttributes({"budget","name"})
public class ItemController {

    private ItemList itemList;


    private String localDate=LocalDate.now().toString();
    public ItemController(ItemList itemList){
        this.itemList=itemList;
    }


    @RequestMapping("/goto-expense")
    public String showExpense(ModelMap model){
       String username= getLoggedInUsername(model);
        List<Item> items=itemList.getItemList(username);
        model.addAttribute("items",items);
        model.put("localDate",localDate);
        model.put("total",itemList.getTotal(username));

        model.putIfAbsent("budget", 0.0);

        double safeToSpend= (Double) model.get("budget");

        double toSpend = itemList.getSafeToSpend(username, safeToSpend);
        if(toSpend<0)
            model.put("lessThan","You have exhausted your savings ):");
        model.put("safeToSpend", toSpend);
        return "expense";
    }



    @RequestMapping(value="/add-expense",method = RequestMethod.GET)
    public String showAddExpensePage(ModelMap model){
        String username= getLoggedInUsername(model);
        Item item=new Item(username,0,"",0,LocalDate.now(),1);

        model.put("item",item);
        return "expense-add";
    }


//    @RequestMapping(value="/add-expense",method = RequestMethod.POST)
//    public String returnToExpense(@RequestParam String name,@RequestParam double price){
//         itemList.addItem(name,price);
//        return "redirect:/goto-expense";
//    }

    //changes done here
    @RequestMapping(value="/add-expense",method = RequestMethod.POST)
    public String addExpense(ModelMap model,@Valid Item item,BindingResult result) {
        String userName= getLoggedInUsername(model);

        if(result.hasErrors() || item.getPrice()<0){
            return "expense-add";
        }

     itemList.addItem(userName, item.getName(),item.getPrice(),item.getLocalDate(),item.getQuantity());

        return "redirect:/goto-expense";
    }


    @RequestMapping(value="/delete-item",method = RequestMethod.GET)
    public String deleteItem(@RequestParam int serialNo,ModelMap model){
       String username= getLoggedInUsername(model);
      itemList.deleteBySerialNo(username,serialNo);
        return "redirect:/goto-expense";
    }


    @RequestMapping(value="/update-item",method=RequestMethod.GET)
    public String showUpdatePage(@RequestParam int serialNo,ModelMap model){
        Item item=itemList.findBySerialNo(serialNo);
        model.put("item",item);
        return "expense-add";
    }


    @RequestMapping(value="/update-item",method=RequestMethod.POST)
    public String updateTOdo(@Valid Item item,BindingResult result){

        if(result.hasErrors())
            return "expense-add";
        itemList.updateItem(item);
        return "redirect:/goto-expense";
    }



    private static String getLoggedInUsername(ModelMap model) {
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return    authentication.getName();
    }

    @RequestMapping(value = "filter-by-date",method = RequestMethod.GET)
    public String filterDate(ModelMap model){
        String username= getLoggedInUsername(model);
        Item item=new Item(username,0,"",0,LocalDate.now(),0);

        model.put("item",item);
        return "filterByDate";
    }

    @RequestMapping(value = "filter-by-date",method = RequestMethod.POST)
    public String ShowFilterByDatePage(@RequestParam LocalDate localDate,ModelMap model) {
        List<Item> items=itemList.filterByDate(localDate, getLoggedInUsername(model));
        model.addAttribute("items",items);
        model.put("total",itemList.getTotal(items));
        if(items.isEmpty()){
            model.put("errorMessage","No items are available with date "+localDate);
        }
        return "expenseFilterByDate";

    }



}

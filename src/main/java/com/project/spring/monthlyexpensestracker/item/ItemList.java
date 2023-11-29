package com.project.spring.monthlyexpensestracker.item;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service

public class ItemList {

    private static List<Item> items =new ArrayList<>();


    private static  int itemCount=1;

    private  double total=65;



    static {
        items.add(new Item("venugopal",itemCount++,"Dosa",40, LocalDate.now(),1));
        items.add(new Item("venugopal",itemCount++,"Pani puri",25,LocalDate.now(),1));
    }




    public void addItem(String username,String name,double price,LocalDate localDate,int quantity){

            items.add(new Item(username,itemCount++,name,price,localDate,quantity));
            total=getTotal(username);


    }

    public double getTotal(String username){
        Predicate<Item> predicate=item -> item.getUsername().equalsIgnoreCase(username);
        List<Item> itemList=items.stream().filter(predicate).toList();
        total=0;
        for(Item item:itemList)
            total+=item.getPrice()*item.getQuantity();

        return total;
    }

    public double getSafeToSpend(String username,double price){
        price-=getTotal(username);
        return price;
    }


    public void removeItem(String name,double price,int quantity){
        items.remove(new Item("venugopal",itemCount++,name,price,LocalDate.now(),quantity));
    }


    public List<Item> getItemList(String username){
        Predicate<Item> predicate=item->username.equalsIgnoreCase(item.getUsername());
        return items.stream().filter(predicate).toList();

    }



    public void deleteBySerialNo(String username,int serialNo) {
      boolean b=items.remove(findBySerialNo(serialNo));
      total=getTotal(username);
    //    System.out.println("In deleteBySerialNo is "+price+" total"+total);

    }


    public void deleteBySerialNo(int serialNo){
        items.remove(findBySerialNo(serialNo));
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void updateItem(@Valid Item item) {

     deleteBySerialNo(item.getSerialNo());
      addItem(item);
        total=getTotal(item.getUsername());

    }

    public Item findBySerialNo(int serialNo) {
        Predicate<Item> predicate=(item)->item.getSerialNo()==serialNo;
        Item item=items.stream().filter(predicate).findFirst().get();
        return item;
    }


    public List<Item> filterByDate(LocalDate localDate) {
        List<Item> list=new ArrayList<>();
        Predicate<Item> itemPredicate=item->item.getLocalDate().equals(localDate);
        list=items.stream().filter(itemPredicate).toList();

        return list;
    }

    public double getTotal(List<Item> items){
        double total=0;
        for(Item item:items){
            total+=item.getPrice();
        }
        return total;
    }


}

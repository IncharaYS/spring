package com.xworkz.componentsapp;

import com.xworkz.componentsapp.components.bag.Bag;
import com.xworkz.componentsapp.components.bank.Bank;
import com.xworkz.componentsapp.components.book.Book;
import com.xworkz.componentsapp.components.bottle.Bottle;
import com.xworkz.componentsapp.components.candle.Candle;
import com.xworkz.componentsapp.components.chair.Chair;
import com.xworkz.componentsapp.components.coffee.Coffee;
import com.xworkz.componentsapp.components.customer.Customer;
import com.xworkz.componentsapp.components.headphone.HeadPhone;
import com.xworkz.componentsapp.components.herb.Herb;
import com.xworkz.componentsapp.components.hospital.Hospital;
import com.xworkz.componentsapp.components.hotel.Hotel;
import com.xworkz.componentsapp.components.institute.Institute;
import com.xworkz.componentsapp.components.laptop.Laptop;
import com.xworkz.componentsapp.components.library.Library;
import com.xworkz.componentsapp.components.medicine.Medicine;
import com.xworkz.componentsapp.components.metro.Metro;
import com.xworkz.componentsapp.components.movie.Movie;
import com.xworkz.componentsapp.components.pen.Pen;
import com.xworkz.componentsapp.components.people.People;
import com.xworkz.componentsapp.components.pg.Pg;
import com.xworkz.componentsapp.components.phone.Phone;
import com.xworkz.componentsapp.components.plant.Plant;
import com.xworkz.componentsapp.components.police.Police;
import com.xworkz.componentsapp.components.projector.Projector;
import com.xworkz.componentsapp.components.shoppingmall.ShoppingMall;
import com.xworkz.componentsapp.components.table.Table;
import com.xworkz.componentsapp.components.train.Train;
import com.xworkz.componentsapp.components.trainer.Trainer;
import com.xworkz.componentsapp.components.wood.Wood;
import com.xworkz.componentsapp.config.CoreConfigurations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentRunner {
    public static void main(String[] args) {

        System.out.println("main started");


        ApplicationContext applicationContext=new
                AnnotationConfigApplicationContext(CoreConfigurations.class);

        Bank bank=applicationContext.getBean(Bank.class);
        System.out.println(bank);

        Hospital hospital=applicationContext.getBean(Hospital.class);
        System.out.println(hospital);

        Chair chair=applicationContext.getBean(Chair.class);
        System.out.println(chair);

        Train train=applicationContext.getBean(Train.class);
        System.out.println(train);

        Metro metro=applicationContext.getBean(Metro.class);
        System.out.println(metro);


        Library library=applicationContext.getBean(Library.class);
        System.out.println(library);

        Book book=applicationContext.getBean(Book.class);
        System.out.println(book);

        Institute institute=applicationContext.getBean(Institute.class);
        System.out.println(institute);


        Bag bag=applicationContext.getBean(Bag.class);
        System.out.println(bag);

        Phone phone=applicationContext.getBean(Phone.class);
        System.out.println(phone);

        Table table=applicationContext.getBean(Table.class);
        System.out.println(table);


        Customer customer=applicationContext.getBean(Customer.class);
        System.out.println(customer);

        Coffee coffee=applicationContext.getBean(Coffee.class);
        System.out.println(coffee);


        Candle candle=applicationContext.getBean(Candle.class);
        System.out.println(candle);

        People people=applicationContext.getBean(People.class);
        System.out.println(people);


        HeadPhone headPhone=applicationContext.getBean(HeadPhone.class);
        System.out.println(headPhone);


        Bottle bottle=applicationContext.getBean(Bottle.class);
        System.out.println(bottle);


        Laptop laptop=applicationContext.getBean(Laptop.class);
        System.out.println(laptop);

        Pen pen=applicationContext.getBean(Pen.class);
        System.out.println(pen);


        Hotel hotel=applicationContext.getBean(Hotel.class);
        System.out.println(hotel);


        Plant plant=applicationContext.getBean(Plant.class);
        System.out.println(plant);

        Police police=applicationContext.getBean(Police.class);
        System.out.println(police);

        ShoppingMall shoppingMall=applicationContext.getBean(ShoppingMall.class);
        System.out.println(shoppingMall);


        Pg pg=applicationContext.getBean(Pg.class);
        System.out.println(pg);

        Projector projector=applicationContext.getBean(Projector.class);
        System.out.println(projector);

        Wood wood=applicationContext.getBean(Wood.class);
        System.out.println(wood);

        Herb herb=applicationContext.getBean(Herb.class);
        System.out.println(herb);

        Medicine medicine=applicationContext.getBean(Medicine.class);
        System.out.println(medicine);

        Movie movie=applicationContext.getBean(Movie.class);
        System.out.println(movie);

        Trainer trainer=applicationContext.getBean(Trainer.class);
        System.out.println(trainer);


        System.out.println("main ended");
    }
}

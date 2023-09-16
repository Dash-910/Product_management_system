package com.manage.product.Product_Management_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Welcom To Product Manangement System");
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	while(true)
    	{
    		 System.out.println("Press * 1 * To Add a Product");
             System.out.println("Press * 2 * To LookUp a Product");
             System.out.println("Press * 3 * To view all Inventery");
             System.out.println("Press * 4 * To Update a Product info");
             System.out.println("Press * 5 * To view Product by Type");
             System.out.println("Press * 6 * To view Product by Brand and Type");
             System.out.println("Press * 7 * To Delete a Product");
             System.out.println("Press * 8 * To Exit app");
             
             int c = Integer.parseInt(br.readLine());
             
             if(c==1)
             {
            	 //Adding a Product
            	 System.out.println("Enter product Name: ");
            	    String name = br.readLine();

            	    System.out.println("Enter product Type: ");
            	    String type = br.readLine();

            	    System.out.println("Enter product Brand: ");
            	    String brand = br.readLine();

            	    System.out.println("Enter product Place: ");
            	    String place = br.readLine();

            	    System.out.println("Enter product Warranty: ");
            	    int warranty = Integer.parseInt(br.readLine());

            	    System.out.println("Enter product Price: ");
            	    double price = Double.parseDouble(br.readLine());

            	    Product product = new Product(name, type, brand, place,price, warranty);

            	    boolean response = ProductDAO.insertProductToDB(product);

            	    if (response) {
            	        System.out.println("Product added Successfully");
            	    } else {
            	        System.out.println("Something went wrong");
            	    }
               }
             else if(c==2)
             {
            	 //View a product info
            	 System.out.println("Enter ProductID");
            	 int id = Integer.parseInt(br.readLine());
            	 
            	 boolean response = ProductDAO.aSingleProduct(id);
            	 
            	 if(response)
            	 {
            		 System.out.println("Product fetched Succesfully");
            	 } else {
            		 System.out.println("Product Not found");
            	 }
             }
             else if(c==3)
             {
            	 //View all products
            	 ProductDAO.showAllProducts();
             }
             else if(c==4)
             {
            	 //Update a Product Info
            	 System.out.println("Enter ProductId to update: ");
            	    int productId = Integer.parseInt(br.readLine());

            	    if (ProductDAO.inProductExists(productId)) {
            	        System.out.println("Enter new Product Name: ");
            	        String newName = br.readLine();

            	        System.out.println("Enter new Product Type: ");
            	        String newType = br.readLine();

            	        System.out.println("Enter new Product Brand: ");
            	        String newBrand = br.readLine();

            	        System.out.println("Enter new Product Place: ");
            	        String newPlace = br.readLine();

            	        System.out.println("Enter new Product Warranty: ");
            	        int newWarranty = Integer.parseInt(br.readLine());

            	        System.out.println("Enter new Product Price: ");
            	        double newPrice = Double.parseDouble(br.readLine());

            	        boolean response = ProductDAO.updateProduct(productId, newName, newType, newBrand, newPlace, newWarranty, newPrice);

            	        if (response) {
            	            System.out.println("Product info updated successfully");
            	        } else {
            	            System.out.println("Something went wrong");
            	        }
            	    } else {
            	        System.out.println("Product with Id " + productId + " does not exist");
            	    }
             }
             else if(c==5)
             {
            	 System.out.println("Enter the product type");
            	 String type = br.readLine();
            	 
            	 boolean response = ProductDAO.getProductByType(type);
            	 if(response)
            	 {
            		 System.out.println("Products fethced sucessfully");
            	 } else {
            		 System.out.println("Something went wrong");
            	 }
             }
             else if(c==6)
             {
            	 System.out.println("Enter the product type and brand");
            	 String type = br.readLine();
            	 String brand = br.readLine();
            	 
            	 boolean response = ProductDAO.getByTypeandBrand(type, brand);
            	 if(response)
            	 {
            		 System.out.println("Products fecthed successfully");
            	 } else {
            		 System.out.println("Something went wrong");
            	 }
             }
             else if(c==7)
             {
            	 System.out.println("Enter the productID");
            	 int id = Integer.parseInt(br.readLine());
            	 
            	 boolean response = ProductDAO.deleteProduct(id);
            	 if(response)
            	 {
            		 System.out.println("Product deleted Successfully");
            	 } else {
            		 System.out.println("Someting went wrong");
            	 }
             }
             else if(c==8)
             {
            	 break;
             }
             else {
            	 System.out.println("Invalid Option");
             }	 
    	}
    }
}

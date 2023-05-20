package com.simpli;

import java.util.*;

public class CameraRentalApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Camera> cameraList = new ArrayList<>();
    private static double walletBalance = 0.0;

    public static void main(String[] args) {
        displayWelcomeMessage();
        login();
    }

    private static void displayWelcomeMessage() {
        System.out.println("+--------------------------------------+");
    	System.out.println("|    WELCOME TO CAMERA RENTAL APP :)   |");
    	System.out.println("+--------------------------------------+");
    	System.out.println("PLEASE LOGIN TO CONTINUE");
    	System.out.println("USERNAME: ");
        String username = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String password = scanner.nextLine();
    }

    private static void login() {
        int choice;
        do {
            System.out.println("\nOPTIONS:");
            System.out.println("1. MY CAMERA");
            System.out.println("2. RENT A CAMERA");
            System.out.println("3. VIEW ALL CAMERAS");
            System.out.println("4. MY WALLET");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    handleMyCamera();
                    break;
                case 2:
                    handleRentCamera();
                    break;
                case 3:
                    handleViewAllCameras();
                    break;
                case 4:
                    handleMyWallet();
                    break;
                case 5:
                    System.out.println("Thank you for using the Camera Rental App :) !");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (true);
    }

    private static void handleMyCamera() {
        int choice;
        do {
            System.out.println("\nMY CAMERA:");
            System.out.println("1. ADD");
            System.out.println("2. REMOVE");
            System.out.println("3. VIEW MY CAMERAS");
            System.out.println("4. GO TO PREVIOUS MENU");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    handleAddCamera();
                    break;
                case 2:
                    handleRemoveCamera();
                    break;
                case 3:
                    handleViewMyCameras();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (true);
    }

    private static void handleAddCamera() {
        System.out.print("Enter the camera brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the per day price (INR): ");
        double perDayPrice = scanner.nextDouble();

        int cameraId = cameraList.size() + 1;
        Camera camera = new Camera(cameraId, brand, model, perDayPrice);
        cameraList.add(camera);

        System.out.println("Your camera has been successfully added to the list :)");
    }

    private static void handleRemoveCamera() {
        handleViewAllCameras();

        System.out.print("Enter the camera ID to remove: ");
        int cameraId = scanner.nextInt();

        boolean removed = cameraList.removeIf(camera -> camera.getId() == cameraId);
        if (removed) {
            System.out.println("Camera successfully removed from the list :)");
        } else {
            System.out.println("Camera not found in the list :(");
        }
    }

    private static void handleViewMyCameras() {
        if (cameraList.isEmpty()) {
            System.out.println("You don't have any cameras rented.");
        } else {
            System.out.println("===========================================================");
            System.out.println("ID\tBrand\t\tModel\t\tPer Day Price (INR)");
            System.out.println("===========================================================");
            for (Camera camera : cameraList) {
                System.out.printf("%d\t%-10s\t%-10s\t%.2f\n", camera.getId(), camera.getBrand(), camera.getModel(), camera.getPerDayPrice());                
            }
            System.out.println("===========================================================");
        }
    }

    private static void handleRentCamera() {
    	handleViewAllCameras();
    	System.out.println("Following is the list of cameras avaliable\n");
    	System.out.print("Enter the camera ID you want to rent: ");
        int cameraId = scanner.nextInt();

        Camera camera = getCameraById(cameraId);
        if (camera != null) {
            if (!camera.isRented()) {
                if (walletBalance >= camera.getPerDayPrice()) {
                    walletBalance -= camera.getPerDayPrice();
                    camera.setRented(true); // Mark the camera as rented
                    System.out.println("Your transaction for camera " + camera.getBrand() + " " + camera.getModel() +
                            " with rent INR." + camera.getPerDayPrice() + " has successfully completed.");
                } else {
                    System.out.println("Error: Transaction failed due to insufficient wallet balance. " +
                            "Please deposit the amount to your wallet.");
                }
            } else {
                System.out.println("Error: Camera is already rented.");
            }
        } else {
            System.out.println("Error: Camera not found :(");
        }
    }

    private static void handleViewAllCameras() {
        if (cameraList.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
        } else {
        	System.out.println("==========================================================================");
        	System.out.println("ID\tBrand\t\tModel\t\tPer Day Price (INR)\tStatus");
        	System.out.println("==========================================================================");
            for (Camera camera : cameraList) {
                String status = camera.isRented() ? "Rented" : "Available";
                System.out.printf("%d\t%-10s\t%-10s\t%.2f\t\t\t%s\n", camera.getId(), camera.getBrand(), camera.getModel(),
                        camera.getPerDayPrice(), status);
                
            }
            System.out.println("==========================================================================");
        }
    }

    private static void handleMyWallet() {
        System.out.println("YOUR CURRENT WALLET BALANCE IS INR." + walletBalance);
        System.out.println("Do you want to deposit more amount to your wallet?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter the amount (INR): ");
                double depositAmount = scanner.nextDouble();
                walletBalance += depositAmount;
                System.out.println("Your wallet balance updated successfully. Current wallet balance: INR." + walletBalance);
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static Camera getCameraById(int cameraId) {
        for (Camera camera : cameraList) {
            if (camera.getId() == cameraId) {
                return camera;
            }
        }
        return null;
    }

    private static class Camera {
        private int id;
        private String brand;
        private String model;
        private double perDayPrice;
        private boolean rented;

        public Camera(int id, String brand, String model, double perDayPrice) {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.perDayPrice = perDayPrice;
            this.rented = false; // Initially set to not rented
        }

        public boolean isAvailable() {
			return false;
		}

		public int getId() {
            return id;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public double getPerDayPrice() {
            return perDayPrice;
        }
        
        public boolean isRented() {
            return rented;
        }

        public void setRented(boolean rented) {
            this.rented = rented;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Brand: " + brand + ", Model: " + model + ", Per Day Price: INR." + perDayPrice;
        }
    }
}

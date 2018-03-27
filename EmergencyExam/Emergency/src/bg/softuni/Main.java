package bg.softuni;

import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.io.Reader;
import bg.softuni.io.Writer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Writer writer = new Writer();

        EmergencyManagementSystem managementSystem = new EmergencyManagementSystem();

        whileLoop:
        while (true) {
            String output = "";
            String[] input = reader.readLine().split("\\|");

            switch (input[0]) {
                case "RegisterPropertyEmergency":
                    output = managementSystem.registerPropertyEmergency(input);
                    break;
                case "RegisterHealthEmergency":
                    output = managementSystem.registerHealthEmergency(input);
                    break;
                case "RegisterOrderEmergency":
                    output = managementSystem.registerOrderEmergency(input);
                    break;
                case "RegisterFireServiceCenter":
                    output = managementSystem.registerFireServiceCenter(input);
                    break;
                case "RegisterMedicalServiceCenter":
                    output = managementSystem.registerMedicalServiceCenter(input);
                    break;
                case "RegisterPoliceServiceCenter":
                    output = managementSystem.registerPoliceServiceCenter(input);
                    break;
                case "ProcessEmergencies":

                    break;
                case "EmergencyReport":
                    break;
                case "EmergencyBreak":
                    break whileLoop;
                default:
                    break;
            }

            writer.writeLine(output);
        }
    }
}

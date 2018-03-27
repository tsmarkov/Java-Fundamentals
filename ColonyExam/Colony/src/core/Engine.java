package core;


import entities.Colony;
import entities.colonists.Colonist;
import entities.colonists.engineers.HardwareEngineer;
import factories.ColonistFactory;
import factories.ColonyFactory;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import utilities.Constants;
import utilities.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;

    private Colony colony;

    //private CarManager carManager;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        // this.carManager = new CarManager();
    }

    public void run() {
        String[] colonyParams = inputReader.readLine().split(" ");
        this.setColony(colonyParams);

        String inputLine = "";

        while (!(inputLine = this.inputReader.readLine()).equals("end")) {
            ArrayList<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(ArrayList<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "insert":
                processInsert(commandParams);
                break;
            case "remove":
                processRemove(commandParams);
                break;
            case "grow":
                this.colony.grow(Integer.parseInt(commandParams.get(0)));
                break;
            case "potential":
                outputWriter.writeLine(String.format("potential: %d", this.colony.getPotential()));
                break;
            case "capacity":
                outputWriter.write(this.colony.getCapacity());
                break;
            case "family":
                processFamily(commandParams);
                break;
        }
    }

    private void processFamily(ArrayList<String> commandParams) {
        String familyId = commandParams.get(0);

        List<Colonist> colonists = this.colony.getColonistsByFamilyId(familyId);

        if (colonists == null) {
            outputWriter.writeLine("family does not exist");
            return;
        }

        outputWriter.writeLine(String.format("%s:", familyId));
        for (Colonist colonist : colonists) {
            outputWriter.writeLine(String.format("-%s: %d", colonist.getId(), colonist.getPotential()));
        }
    }

    private void processRemove(ArrayList<String> commandParams) {
        String modificator = commandParams.get(0);
        String familyId = commandParams.get(1);
        String colonistId;

        if (modificator.equals("family")) {
            this.colony.removeFamily(familyId);
        } else {
            colonistId = commandParams.get(2);
            this.colony.removeColonist(familyId, colonistId);
        }
    }

    private void processInsert(ArrayList<String> commandParams) {
        String colonistClass = commandParams.get(0);
        String colonistId = commandParams.get(1);
        String familyId = commandParams.get(2);
        int talent = Integer.parseInt(commandParams.get(3));
        int age = Integer.parseInt(commandParams.get(4));
        String sign = "";

        switch (colonistClass) {
            case "SoftwareEngineer":
                this.colony.addColonist(ColonistFactory.createSoftwareEngineer(colonistId, familyId, talent, age));
                break;
            case "HardwareEngineer":
                this.colony.addColonist(ColonistFactory.createHardwareEngineer(colonistId, familyId, talent, age));
                break;
            case "Soldier":
                this.colony.addColonist(ColonistFactory.createSoldier(colonistId, familyId, talent, age));
                break;
            case "GeneralPractitioner":
                sign = commandParams.get(5);
                this.colony.addColonist(ColonistFactory.createGeneralPractitioner(colonistId, familyId, talent, age, sign));
                break;
            case "Surgeon":
                sign = commandParams.get(5);
                this.colony.addColonist(ColonistFactory.createSurgeon(colonistId, familyId, talent, age, sign));
                break;
        }
    }

    private void setColony(String[] colony) {
        int maxFamilyCount = Integer.parseInt(colony[0]);
        int maxFamilyCapacity = Integer.parseInt(colony[1]);

        this.colony = ColonyFactory.makeColony(maxFamilyCount, maxFamilyCapacity);
    }
}

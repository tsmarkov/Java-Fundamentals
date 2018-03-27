package boat_racing_simulator.core;

import boat_racing_simulator.annotations.Inject;
import boat_racing_simulator.contracts.BoatSimulatorController;
import boat_racing_simulator.contracts.CommandHandler;
import boat_racing_simulator.contracts.Executable;
import boat_racing_simulator.exeptions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    private static final String COMMAND_CLASS_PATH = "boat_racing_simulator.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    public String executeCommand(String commandName, List<String> params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        this.params = params;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + commandName + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor();
        Executable command = constructor.newInstance();
        injectDependencies(command);
        String result = command.execute();
        return result;
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fieldsBaseCommand = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsCommand = executable.getClass().getDeclaredFields();
        Field[] allFields = null;
        if (fieldsCommand.length > 0) {
            allFields = new Field[fieldsBaseCommand.length + fieldsCommand.length];
            System.arraycopy(fieldsBaseCommand, 0, allFields, 0, fieldsBaseCommand.length);
            System.arraycopy(fieldsCommand, 0, allFields, fieldsBaseCommand.length, fieldsCommand.length);
        }

        for (Field field : fieldsCommand.length > 0 ? allFields : fieldsBaseCommand) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}
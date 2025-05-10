package ru.sdmitriy612.command;

import ru.sdmitriy612.collection.CollectionManager;
import ru.sdmitriy612.collection.flat.Flat;
import ru.sdmitriy612.interactors.Request;
import ru.sdmitriy612.interactors.Response;

import java.util.Set;
/**
 * Command that displays all the elements in the collection.
 * <p>
 * This command retrieves all elements from the collection managed by {@link CollectionManager}
 * and formats them into a string representation for display.
 * </p>
 */
public class Show extends Command{
    /**
     * Constructs the command with a description and command type.
     */
    public Show(){
        super("displays all collection elements", CommandType.PRIMITIVE);
    }
    /**
     * Executes the command to display all elements in the collection.
     *
     * @param request the request object containing any arguments (not used in this case)
     * @return a {@link Response} containing the string representation of all elements in the collection
     */
    @Override
    public Response execute(CommandArgs request) {
        Set<Flat> collection = CollectionManager.getInstance().getCollection();
        StringBuilder stringBuilder = new StringBuilder();
        collection.stream()
                .sorted().
                forEach(element -> stringBuilder.append(element.toString()).append(System.lineSeparator()));

        return new Response(stringBuilder.isEmpty() ? "collection is empty" : stringBuilder.toString());
    }
}

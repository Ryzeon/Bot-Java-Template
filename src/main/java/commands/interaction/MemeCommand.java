package commands.interaction;

import com.fasterxml.jackson.core.JsonParser;
import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;


/**
 * Project: Casel
 * Date: 11/02/2021 @ 17:32
 * Class: MemCommand
 */
@CommandSubscribe(
        name = "meme"
)
public class MemeCommand implements Command{

    @Override
    public void execute(CommandContext commandContext) throws Exception {

    }
}

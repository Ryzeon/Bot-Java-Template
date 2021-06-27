package commands;


import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;

/**
 * Project: Casel
 * Date: 07/02/2021 @ 12:43
 * Class: BotCommand
 */
@CommandSubscribe(
        name = "ping",
        aliases = {"latency"}
)
public class PingCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        final long time = System.currentTimeMillis();
        ctx.getChannel().sendMessage("> Pong!").queue(response -> {
            response.editMessageFormat("Pong! My ping is `%d ms`", System.currentTimeMillis() - time).queue();
        });

    }
}

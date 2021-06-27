package commands.moderation;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.entities.Message;

import java.util.List;

/**
 * Project: Casel
 * Date: 11/02/2021 @ 21:19
 * Class: ClearCommand
 */
@CommandSubscribe(
        name = "clear"
)
public class ClearCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        String[] args = ctx.getEvent().getMessage().getContentRaw().split(" ");
        if (args.length > 2){
            ctx.getChannel().sendMessage("Use: /clear <amount>").queue();
        }else{
            List<Message> messageList = ctx.getEvent().getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
            ctx.getEvent().getChannel().purgeMessages(messageList);
        }
    }
}

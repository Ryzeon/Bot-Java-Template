package commands.moderation;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

import java.util.Arrays;

/**
 * Project: Casel
 * Date: 09/02/2021 @ 17:28
 * Class: BanCommand
 */
@CommandSubscribe(
        name = "ban",
        aliases = {"blacklist"}
)
public class BanCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        String[] args = ctx.getArguments();
        if (!ctx.getMember().hasPermission(Permission.BAN_MEMBERS)){
            ctx.getChannel().sendMessage("You dont have permissions to use that!").queue();
        }
        if (ctx.getMember().hasPermission(Permission.BAN_MEMBERS)){
            for (Member member : ctx.getEvent().getMessage().getMentionedMembers()){
                member.ban(1000, "Banned by operator!").queue();
                ctx.getChannel().sendMessage("Member " + member.getAsMention() + " has been banned by operator.").queue();
            }
        }
    }
}

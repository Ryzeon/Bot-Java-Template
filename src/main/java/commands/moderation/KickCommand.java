package commands.moderation;

import com.github.m5rian.jdaCommandHandler.Command;
import com.github.m5rian.jdaCommandHandler.CommandContext;
import com.github.m5rian.jdaCommandHandler.CommandSubscribe;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

import java.util.Arrays;

/**
 * Project: Casel
 * Date: 09/02/2021 @ 17:51
 * Class: KickCommand
 */
@CommandSubscribe(
        name = "kick"
)
public class KickCommand implements Command {
    @Override
    public void execute(CommandContext ctx) throws Exception {
        String[] args = ctx.getArguments();
        if (!ctx.getMember().hasPermission(Permission.KICK_MEMBERS)){
            ctx.getChannel().sendMessage("You dont have permissions to use that!").queue();
        }
        if (ctx.getMember().hasPermission(Permission.KICK_MEMBERS)){
            for (Member member : ctx.getEvent().getMessage().getMentionedMembers()){
                member.kick(Arrays.toString(new String[]{args[2]})).queue();
                ctx.getChannel().sendMessage("Member " + member.getAsMention() + " has been kicked by operator.").queue();
            }
        }
    }
}

package manager;

import com.github.m5rian.jdaCommandHandler.CommandListener;
import com.github.m5rian.jdaCommandHandler.commandServices.DefaultCommandService;
import com.github.m5rian.jdaCommandHandler.commandServices.DefaultCommandServiceBuilder;
import commands.*;
import commands.moderation.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * Project: Casel
 * Date: 06/02/2021 @ 21:59
 * Class: manager.StartCasel
 */
public enum StartCasel {
    INTANCE;
    public void startBot() throws LoginException {
        //Set Prefix A CommandAPI Value
        DefaultCommandService commandService = new DefaultCommandServiceBuilder()
                .setDefaultPrefix("/")
                .build();
        //Set Tokens And Register Listener
        JDA jdabuilder = JDABuilder.createDefault("yourtokens")
                .addEventListeners(new CommandListener(commandService))
                .build();
        //Register All Commands
        commandService.registerCommand(new PingCommand());
        commandService.registerCommand(new AvCommand());
        commandService.registerCommand(new BanCommand());
        commandService.registerCommand(new KickCommand());
        commandService.registerCommand(new ClearCommand());
        commandService.registerCommand(new HelpCommand());
        commandService.registerCommand(new ServerCommand());
        commandService.registerCommand(new UserCommand());
    }
}

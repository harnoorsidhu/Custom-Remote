package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */  
import java.util.Stack;
import java.io.*;
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    Command undoCommand, redoCommand;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;
    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        undoStack= new Stack<Command>();
        redoStack= new Stack<Command>();

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
        redoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot)  {
        try{
        onCommands[slot].executeWithLog();
        undoCommand = onCommands[slot];
        undoStack.push((Command)undoCommand.clone());}
       catch(IOException e ){}
       catch(CloneNotSupportedException f) {}
        
    }

    public void offButtonWasPushed(int slot)   {
        try{
        offCommands[slot].executeWithLog();
        undoCommand = offCommands[slot];
        undoStack.push((Command)undoCommand.clone());
    }
    catch(IOException e){}
    catch(CloneNotSupportedException f) {}
    }
     public void undoButtonWasPushed() throws IOException {
         if (undoStack.empty()) {return;}
         undoCommand=undoStack.pop();
        undoCommand.undoWithLog();
        redoStack.push(undoCommand);
    }
    public void redoButtonWasPushed()  throws IOException{
        if (redoStack.empty()) {return;}
        redoCommand=redoStack.pop();
        redoCommand.executeWithLog();
        undoStack.push(redoCommand);
        
    }


    /* for debugging / testing */
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
} 
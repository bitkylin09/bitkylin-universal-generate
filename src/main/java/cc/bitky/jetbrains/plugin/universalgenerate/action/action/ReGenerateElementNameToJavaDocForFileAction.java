package cc.bitky.jetbrains.plugin.universalgenerate.action.action;

import cc.bitky.jetbrains.plugin.universalgenerate.action.action.base.AbstractUniversalGenerateAction;
import cc.bitky.jetbrains.plugin.universalgenerate.constants.ActionEnum;
import cc.bitky.jetbrains.plugin.universalgenerate.factory.CommandCommandTypeProcessorFactory;
import cc.bitky.jetbrains.plugin.universalgenerate.pojo.WriteCommand;
import cc.bitky.jetbrains.plugin.universalgenerate.pojo.WriteContext;
import cc.bitky.jetbrains.plugin.universalgenerate.util.WriteCommandActionUtils;
import cc.bitky.jetbrains.plugin.universalgenerate.util.builder.WriteContextActionBuilder;
import com.intellij.openapi.actionSystem.AnActionEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author bitkylin
 */
@Slf4j
public class ReGenerateElementNameToJavaDocForFileAction extends AbstractUniversalGenerateAction {

    public ReGenerateElementNameToJavaDocForFileAction(String text) {
        super(text);
    }

    public ReGenerateElementNameToJavaDocForFileAction() {
        super();
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        WriteContext writeContext = WriteContextActionBuilder.create(anActionEvent);

        WriteCommandActionUtils.runWriteCommandAction(writeContext.fetchProject(), () -> {
            CommandCommandTypeProcessorFactory.decide(writeContext, WriteCommand.Command.RE_GENERATE_ELEMENT_NAME_TO_JAVA_DOC).writeFile();
        });
    }

    @Override
    protected ActionEnum fetchActionEnum() {
        return ActionEnum.RE_GENERATE_ELEMENT_NAME_TO_JAVA_DOC_FOR_FILE;
    }
}

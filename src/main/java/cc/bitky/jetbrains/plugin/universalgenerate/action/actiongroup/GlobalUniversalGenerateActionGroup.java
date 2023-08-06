package cc.bitky.jetbrains.plugin.universalgenerate.action.actiongroup;

import cc.bitky.jetbrains.plugin.universalgenerate.action.actiongroup.base.AbstractBitkylinUniversalGenerateActionGroup;
import cc.bitky.jetbrains.plugin.universalgenerate.config.ActionConfig;
import cc.bitky.jetbrains.plugin.universalgenerate.config.settings.state.GlobalSettingsStateHelper;
import cc.bitky.jetbrains.plugin.universalgenerate.constants.ActionGroupEnum;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * @author bitkylin
 */
@Slf4j
public class GlobalUniversalGenerateActionGroup extends AbstractBitkylinUniversalGenerateActionGroup {

    @Override
    public void update(@NotNull AnActionEvent anActionEvent) {
        super.update(anActionEvent);

        ActionConfig actionConfig = new ActionConfig();
        if (!GlobalSettingsStateHelper.getInstance().isContextMenuShowed()) {
            anActionEvent.getPresentation().setVisible(false);
            return;
        }
        if (DumbService.isDumb(anActionEvent.getProject())) {
            updateGroupText(anActionEvent, actionConfig, ActionGroupEnum.GLOBAL_UNIVERSAL_GENERATE, null);
            return;
        }
        updateGroupText(anActionEvent, actionConfig, ActionGroupEnum.GLOBAL_UNIVERSAL_GENERATE, null);

    }
}
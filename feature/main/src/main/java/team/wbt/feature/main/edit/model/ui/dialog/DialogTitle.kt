package team.wbt.feature.main.edit.model.ui.dialog

sealed class DialogTitle(
    open val title: String,
) {

    data class TitleOnly(
        override val title: String,
    ) : DialogTitle(title)

    data class TitleWithSubTitle(
        override val title: String,
        val subTitle: String,
    ) : DialogTitle(title)
}

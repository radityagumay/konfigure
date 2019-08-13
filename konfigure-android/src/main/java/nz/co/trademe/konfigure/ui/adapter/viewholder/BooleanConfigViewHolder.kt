package nz.co.trademe.konfigure.ui.adapter.viewholder

import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_holder_boolean.*
import nz.co.trademe.konfigure.ui.adapter.ConfigAdapterModel
import nz.co.trademe.konfigure.R
import nz.co.trademe.konfigure.extensions.applicationConfig

internal class BooleanConfigViewHolder(
    parent: ViewGroup
) : BaseViewHolder(parent.inflate(R.layout.view_holder_boolean)) {

    fun bind(model: ConfigAdapterModel.BooleanConfig) {
        itemView.setOnClickListener {
            valueSwitch.toggle()
        }

        titleTextView.text = model.metadata.title
        titleTextView.showAsModified(model.isModified)

        descriptionTextView.text = model.metadata.description

        valueSwitch.setOnCheckedChangeListener(null)
        valueSwitch.isChecked = model.value
        valueSwitch.setOnCheckedChangeListener { _, newValue ->
            itemView.context.applicationConfig.setValueOf(model.item, newValue)
        }
    }
}
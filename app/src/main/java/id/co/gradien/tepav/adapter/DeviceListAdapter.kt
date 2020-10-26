package id.co.gradien.tepav.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.gradien.tepav.R
import id.co.gradien.tepav.data.DeviceModel
import kotlinx.android.synthetic.main.item_device.view.*

class DeviceListAdapter(list: List<DeviceModel>) : RecyclerView.Adapter<DeviceListAdapter.DeviceVH>() {

    private lateinit var context: Context
    private var deviceList: MutableList<DeviceModel> = list as MutableList<DeviceModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceVH {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return DeviceVH(inflater, parent)
    }

    override fun onBindViewHolder(holder: DeviceVH, position: Int) {
        val device = deviceList[position]
        val view = holder.itemView

        view.textDeviceName.text = device.name
    }

    override fun getItemCount(): Int = deviceList.size

    internal fun setData(list: MutableList<DeviceModel>){
        deviceList = list
        notifyDataSetChanged()
    }

    class DeviceVH(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_device, parent, false))
}

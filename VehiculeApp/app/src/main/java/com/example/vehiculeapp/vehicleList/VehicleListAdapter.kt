package com.example.vehiculeapp.vehicleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vehiculeapp.R
import com.example.vehiculeapp.model.Vehicle
import kotlinx.android.synthetic.main.item_vehicle.view.*


class VehicleListAdapter(private val myDataset: ArrayList<Vehicle> = arrayListOf()) :
    RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder>() {

    // var typeSelectionListenerListener: OnTypeSelectionListener? = null

    class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameTv: TextView? = itemView.item_vehicle_name_tv
        val iconIv: ImageView? = itemView.item_vehicle_icon_iv
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehicleListAdapter.VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false) as View
        return VehicleViewHolder(view)
    }


    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle: Vehicle = myDataset[position]
        holder.nameTv?.text = vehicle.name


        holder.itemView.setOnClickListener {
            // typeSelectionListenerListener?.onTypeSelected(cuurentElement)
        }
    }
    
    override fun getItemCount() = myDataset.size

    fun setVehicleList(vehicleList: List<Vehicle>) {
        myDataset.clear()
        myDataset.addAll(vehicleList)
        notifyDataSetChanged()
    }
}

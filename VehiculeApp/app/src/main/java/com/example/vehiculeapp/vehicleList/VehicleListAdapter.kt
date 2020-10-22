package com.example.vehiculeapp.vehicleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.vehiculeapp.R
import com.example.vehiculeapp.model.Vehicle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_vehicle.view.*


class VehicleListAdapter(private val myDataSet: ArrayList<Vehicle> = arrayListOf()) :
    RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameTv: TextView? = itemView.item_vehicle_name_tv
        val iconIv: ImageView? = itemView.item_vehicle_icon_iv
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false) as View
        return VehicleViewHolder(view)
    }


    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle: Vehicle = myDataSet[position]
        holder.nameTv?.text = vehicle.name
        Picasso.get().load(vehicle.icon.url.size50x50).into(holder.iconIv);

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${vehicle.id}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = myDataSet.size

    fun setVehicleList(vehicleList: List<Vehicle>) {
        myDataSet.clear()
        myDataSet.addAll(vehicleList)
        notifyDataSetChanged()
    }
}

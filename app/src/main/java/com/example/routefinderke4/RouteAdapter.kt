package com.example.routefinderke4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RouteAdapter(
    private val routes: List<Route>,
    private val onItemClick: (Route) -> Unit
) : RecyclerView.Adapter<RouteAdapter.RouteViewHolder>() {

    class RouteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textRouteNumber: TextView = view.findViewById(R.id.textRouteNumber)
        val textRoutePath: TextView = view.findViewById(R.id.textRoutePath)
        val textRouteFare: TextView = view.findViewById(R.id.textRouteFare)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_route, parent, false)
        return RouteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val route = routes[position]
        holder.textRouteNumber.text = "Route ${route.number}"
        holder.textRoutePath.text = "${route.origin} to ${route.destination}"
        holder.textRouteFare.text = "Fare: ${route.fare}"
        holder.itemView.setOnClickListener { onItemClick(route) }
    }

    override fun getItemCount() = routes.size
}

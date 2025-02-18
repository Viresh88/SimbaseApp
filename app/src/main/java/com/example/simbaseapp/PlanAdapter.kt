package com.example.simbaseapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanAdapter(
    private val plans: List<DataPlan>,
    private val onPlanSelected: (DataPlan) -> Unit
) : RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {

    class PlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val planId : TextView = view.findViewById(R.id.planId)
        val planName: TextView = view.findViewById(R.id.planName)
        val planDay : TextView = view.findViewById(R.id.planDay)
        val planmb : TextView = view.findViewById(R.id.planmb)
        val plansms : TextView = view.findViewById(R.id.plansms)
        val plansmstodevice : TextView = view.findViewById(R.id.plansmstodevice)
        val countries : TextView = view.findViewById(R.id.countries)
        val planCurrency : TextView = view.findViewById(R.id.planCurrecncy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plan_item, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val plan = plans[position]
        holder.planId.text = plan.id.toString()
        holder.planName.text = plan.name
        holder.planDay.text = plan.day.toString()
        holder.planmb.text = plan.mb.toString()
        holder.plansms.text = plan.sms.toString()
        holder.plansmstodevice.text = plan.smstodevice.toString()
        holder.countries.text = plan.countries.toString()
        holder.planCurrency.text = plan.currency
        holder.itemView.setOnClickListener {
            onPlanSelected(plan)
        }
    }

    override fun getItemCount() = plans.size
}

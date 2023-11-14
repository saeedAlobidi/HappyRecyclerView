# HappyRecyclerView



` 
//main function
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
{
    var  JobList =  view.findViewById(R.id.JobList) as HappyRecyclerView<String>
       
        var adpter1 =
            JobList.CAdapter(R.layout.company_card, ::bindViewHolderF, ::viewHolderF)
     

        adpter1.setData(arrayListOf("Item 1", "Item 2", "Item 3"))
        adpter1.setData(arrayListOf("Item 1", "Item 2", "Item 3"))
        }


// bindViewHolder  function
    fun bindViewHolderF(holder: HappyRecyclerView.Adapter.ViewHolder, item: String): Unit {

    }

//  viewHolder  function
    fun viewHolderF(itemView: View, context: Context): Unit {

    }

`

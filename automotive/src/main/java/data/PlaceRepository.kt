package data

import data.model.Place


var place= listOf(
    Place(1,
        "DLF Mall of India, Noida",
        "DLF Mall of India is the Biggest & Largest Mall in Noida, with 300 stores, 250+ brands of products, and various dining, entertainment, and food options. DLF stands for Delhi Land and Finance. Delhi Land and Finance is one of the largest commercial real estate developer in India. The company was founded by Chaudhary Raghvendra Singh in 1946. The headquarter of DLF is in New Delhi, India.",
        28.567190,
        77.320892),
    Place(2,
        "Phoenix Market City, Mumbai",
        "Phoenix Market City in Mumbai is the third largest shopping mall in India. It is developed by The Phoenix Mills Co. Ltd., and has a total area of 1.4 million square feet with over 350 stores. The mall also features a food court, multiplex, and a gaming zone. Shop, dine, and experience luxury under one roof.",
        19.0864,
        72.8890),
    Place(3,
        "Lulu International Shopping Mall, Kochi",
        "Lulu International Shopping Mall in Kochi is the seventh largest shopping mall in India. It has a total area of 0.7 million square feet and offers over 150 stores. The mall also features a food court, multiplex, and a gaming zone. The estimated cost for this project was more than ₹1,600 crore (US \$273.05 million). The property is owned and managed by Abu Dhabi based LuLu Group International.",
        10.026617,
        76.308411),
    Place(4,
        "Orion Mall, Bangalore",
        "Orion Mall in Bangalore is the eighth largest shopping mall in India. It has a total area of 0.6 million square feet and offers over 150 stores. The mall also features a food court, multiplex, and a gaming zone. Orion Mall is part of a premium integrated enclave known as Brigade Gateway which houses World Trade Center, Sheraton Grand Hotel, Columbia Asia Hospital apart from the mall in its premises.",
        13.011053,
        77.554939),
    Place(5,
        "Select Citywalk, Delhi",
        "Select Citywalk in Delhi is the fourth largest shopping mall in India. It has a total area of 1 million square feet and offers over 150 stores. The mall also features a food court, multiplex, and a gaming zone. The mall was developed by Select Infrastructure, a joint venture between the Select group and the Aarone Group. It was opened to the public in October 2007.",
        28.51918,
        77.21301)
)
class PlaceRepository(){
    fun getPlaces():List<Place>{
        return place
    }
    fun getPlace(placeId: Int):Place?{
        return place.find { it.id== placeId }
    }
}

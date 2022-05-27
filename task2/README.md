# Task 2

### Engineering Comments

- Recyclerview for showing list of recipes
- Glide for fetching images of recipes
- Coroutines for thread management
- MVVM architecture pattern
- View Data binding
- Roboto-bold for font
- Koin Dependency Injection (Dagger was unable to create component on my machine, Investigated for 3 hrs and then applied koin di)
- Mappers for converting API model to UI model
- SOLID principles applied
- Retrofit as networking library with GSON converter 

### Decision Points

- Could have used a single model for API and UI but learned about having separate models for better scalability
- Assumed all the attributes of json object are not null, which is why all elements in Model classes are not null
- Though of using a default vector shape as recipe banner but removed it in previous commits, in order to restrain
  size of executable from increasing. Used shaped instead for better User experience. 
- Used DiffUtil rather than notifying data set changes, for better performance
- Created separate library for utils so it can be reused
- Used ViewHolder pattern with recycler adapter for increased scalability and to comply with Google standards

### Improvements for Future

- For multiple brands from single code base, we would need multiple flavors, that would be first thing to do
- Add pipeline files (bitbucker-pipeline.yml | bitrise) to trigger CI process
- Write Unit cases for presentation and business logic
- Create handlers for click listeners
- Setting up feature flags to do A/B test (fun with flag)
- Implement caching strategy
- Make UI a bit more nicer than it is now
- Add Timber for log management of crashes and ANR's
- Organize gradle dependencies
- Segregate task2 into more modules to increase or speed up build process
- Adding proguard or R8 to reduce for optimized executable 

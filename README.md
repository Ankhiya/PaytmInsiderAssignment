# PaytmInsiderAssignment
Assignment task from PaytmInsider

## Architecture Overview
adapter - holds adapters for view pager and recycler view

application - holds application base class and app components

model - holds model pojo classes

repository - holds classes for data repository from network

utils - holds String utils

view - holds view classes of activity, fragment

viewholder - holds view model classes

## Used libraries
Glide - for network image loading
Retrofit - for Network Api calling

## Behaviour of app
As user launches app, events api gets called for 'Noida' city.
The groups of events are the tabs of view pager.
For every group, the fragment shows list of events for that group.
For any network or api error, error view will be shown with retry view.
For no results, no results message is shown.

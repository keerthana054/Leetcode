var cancellable = function(generator) {
    let cancel;
    /* Creating the Cancel Promise */
    const cancelPromise = new Promise((_, reject) => {
        cancel = () => reject("Cancelled");
    });

    /* Catching all the Cancelled Promises :) */
    cancelPromise.catch(() => {});

    const promise = (async() => {
        let next = generator.next();
        while(!next.done){
            try{
                next = generator.next(await Promise.race([next.value, cancelPromise]));
                /* 
                    Processing the Generator Yield, 
                    Continues iterating through the generator until it's done or cancelled.
                */
            }catch(error){
                next = generator.throw(error);
            }
        }

        return next.value;
    })();

    return [cancel, promise];
};
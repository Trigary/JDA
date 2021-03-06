/*
 * Copyright 2015-2019 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.requests.restaction.pagination;

import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;

/**
 * {@link PaginationAction PaginationAction} that paginates the reaction users endpoint.
 * <br>Note that this implementation is not considered thread-safe as modifications to the cache are not done
 * with a lock. Calling methods on this class from multiple threads is not recommended.
 *
 * <p><b>Must provide not-null {@link net.dv8tion.jda.api.entities.MessageReaction MessageReaction} to compile a valid
 * pagination route.</b>
 *
 * <h2>Limits:</h2>
 * Minimum - 1
 * <br>Maximum - 100
 *
 * <h1>Example</h1>
 * <pre>{@code
 * ReactionPaginationAction users = reaction.retrieveUsers();
 *
 * Optional<User> optUser = users.stream().skip(ThreadLocalRandom.current().nextInt(reaction.getCount())).findFirst();
 * optUser.ifPresent( (user) -> user.openPrivateChannel().queue(
 *         (channel) -> channel.sendMessage("I see you reacted to my message :eyes:").queue()
 * ));
 * }</pre>
 *
 * @since  3.1
 *
 * @see    MessageReaction#retrieveUsers()
 */
public interface ReactionPaginationAction extends PaginationAction<User, ReactionPaginationAction>
{
    /**
     * The current target {@link net.dv8tion.jda.api.entities.MessageReaction MessageReaction}
     *
     * @return The current MessageReaction
     */
    @Nonnull
    MessageReaction getReaction();
}
